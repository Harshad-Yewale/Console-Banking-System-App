package bankService;

import domain.Account;
import domain.Transactions;

import java.util.List;

public interface BankService {

    public String createAccount(String name,String email,String accountType);

    public List<Account> listAcc();

    public String depositAmount(String customerId, Double amount, String note);

    public String withDrawAmount(String acId,double amount,String note);

    public String transferAmount(String sender, String receiver, double amount,String note);

    public List<Transactions> listStatement(String ac);
}
