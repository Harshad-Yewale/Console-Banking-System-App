package bankService.impl;

import domain.Account;
import bankService.BankService;
import domain.Customer;
import domain.Transactions;
import domain.Type;
import repository.AccountRepository;
import repository.customerRepository;
import repository.transactionRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class BankServiceImpl implements BankService {


    AccountRepository ac=new AccountRepository();
    transactionRepository tr= new transactionRepository();

    @Override
    public String createAccount(String name,String email,String accountType){

        String customerId= String.valueOf(UUID.randomUUID());
        String accountNumber = getString();
        Customer customer=new Customer(customerId,name,email,accountNumber);
        Account account=new Account(accountNumber,customerId,(double)0,accountType);
        ac.save(account);
        return accountNumber;
    }
    private String getString() {
        int temp=ac.findAll().size()+1;
        return String.format("AC%06d",temp);
    }

    @Override
    public List<Account> listAcc() {
        return ac.findAll().stream().toList();
    }

    @Override
    public String depositAmount(String customerId, Double amount, String note) {
        try {
            Account acc = ac.findById(customerId).orElseThrow(() -> new RuntimeException("account not found"));
            acc.setBalance(acc.getBalance() + amount);
            Transactions transaction = new Transactions(Type.DEPOSIT, UUID.randomUUID().toString(), acc.getAccountNumber(), amount, LocalDateTime.now(), note);
            tr.add(transaction);
            return "Amount deposited Successfully";
        }
        catch (RuntimeException e){
            return  "Account not found! plz enter the valid account number";
        }

    }

    @Override
    public String withDrawAmount(String acId, double amount, String note) {
        try {
            Account acc = ac.findById(acId).orElseThrow(() -> new RuntimeException("Account not found"));
            if (acc.getBalance().compareTo(amount) < 0) {
                return "inSufficient Balance";
            }
            acc.setBalance(acc.getBalance() - amount);
            Transactions transaction = new Transactions(Type.WITHDRAW, UUID.randomUUID().toString(), acc.getAccountNumber(), amount, LocalDateTime.now(), note);
            tr.add(transaction);
            return "Amount Withdrawn Successfully";
        } catch (RuntimeException e) {
            return "Account not found! plz enter the valid account number";
        }
    }

    @Override
    public String transferAmount(String sender, String receiver, double amount,String note) {
        try{
            Account acc=ac.findById(sender).orElseThrow(()->new RuntimeException());
            if (acc.getBalance().compareTo(amount)<0){
                return "insufficient Balance!!";
            }
            Account acc2=ac.findById(receiver).orElseThrow(()->new RuntimeException());
            //update senders account
            acc.setBalance(acc.getBalance()-amount);
            Transactions transaction=new Transactions(Type.TRANSFER_OUT,UUID.randomUUID().toString(),acc.getAccountNumber(),amount,LocalDateTime.now(),note);
            tr.add(transaction);

            //update receivers account
            acc2.setBalance(acc2.getBalance()+amount);
            Transactions transaction2=new Transactions(Type.TRANSFER_IN,UUID.randomUUID().toString(),acc.getAccountNumber(),amount,LocalDateTime.now(),note);
            tr.add(transaction2);
            return "Amount transferred successfully";
        }
        catch (RuntimeException e){
            return "Account not found!! plz enter valid account id";
        }
    }

    @Override
    public List<Transactions> listStatement(String account) {
        return tr.findByAccount(account).stream().toList();
    }


}
