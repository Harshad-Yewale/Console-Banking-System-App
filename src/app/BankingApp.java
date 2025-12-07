package app;

import java.util.List;
import java.util.Scanner;
import bankService.BankService;
import bankService.impl.BankServiceImpl;
import domain.Account;
import domain.Transactions;


public class BankingApp {
    public static void main(String[] args) {

        String option;
        boolean isRunning=true;
        Scanner sc =new Scanner(System.in);
        BankService AccountService=new BankServiceImpl();

        System.out.println("Welcome to the console Banking System");

        while(isRunning) {

            System.out.println("""
                    Plz Select any 1 Option from the following:
                    1) Open Account
                    2) Deposit
                    3) Withdraw
                    4) Transfer
                    5) Account Statements
                    6) List Accounts
                    0) Exit
                    """);
            System.out.println("Plz Choose any 1 Option: ");
            option = sc.nextLine().trim();


            switch (option) {
                case "1":
                    String acNumber=createAccount(sc,AccountService);
                    System.out.println("Account created!!\n your Account Number: "+acNumber);
                    break;
                case "2":
                    depositAmount(sc,AccountService);
                    break;
                case "3":
                    withdrawAmount(sc,AccountService);
                    break;
                case "4":
                    transferMoney(sc,AccountService);
                    break;
                case "5":
                    listStatements(sc,AccountService);
                    System.out.println("Account Statements!!");
                    break;
                case "6":
                    listAccount(sc,AccountService);
                    break;
                case "0":
                    isRunning=false;
                    break;
                default:
                    System.out.println("plz enter a valid Option");
            }
        }
    }

    private static void listStatements(Scanner sc, BankService accountService) {
        System.out.println("Account number: ");
        String ac=sc.nextLine();
        List<Transactions> transactions=accountService.listStatement(ac);
        transactions.forEach(transactions1 -> {
            System.out.printf("|%-15s||%-15s||%-15s||%-11.2f||%-15s",transactions1.getTransactionId(),transactions1.getAccountNumber(),transactions1.getTransactionType(),transactions1.getAmount(),transactions1.getTimeStamp());
        });

    }

    private static void transferMoney(Scanner sc, BankService accountService) {
        System.out.println("Sender's Account No:");
        String sender=sc.nextLine();
        System.out.println("Receiver's Account No:");
        String receiver=sc.nextLine();
        System.out.println("Amount to transfer:");
        double amount=Double.parseDouble(sc.nextLine());
        String result=accountService.transferAmount(sender,receiver,amount,"Money Transferred");
        System.out.println(result);

    }

    private static void withdrawAmount(Scanner sc, BankService accountService) {
        System.out.print("Account Number: ");
        String acNumber=sc.nextLine().trim();
        System.out.print("Amount  to withdraw: ");
        double amt=Double.parseDouble(sc.nextLine());
        System.out.print("Any note you want to attach: ");
        String note=sc.nextLine();
        String result=accountService.withDrawAmount(acNumber,amt,note);
        System.out.println(result);
    }


    // Account Creation Function
    public static String createAccount(Scanner sc, BankService accountService){
        System.out.print("Your Name: ");
        String name=sc.nextLine().trim();
        System.out.print("Your Email: ");
        String email=sc.nextLine().trim();
        System.out.print("Your Account type (CURRENT/SAVINGS): ");
        String accountType=sc.nextLine().trim();
        System.out.print("Your Initial Deposit amount: ");
        double amt=Double.parseDouble(sc.nextLine());
        String acNumber= accountService.createAccount(name,email,accountType);
        if (amt>0){
            accountService.depositAmount(acNumber,amt,"Initial Deposit"); //to deposit initial amount.
        }
        return acNumber;
    }

    //List account Function
    private static void listAccount(Scanner sc, BankService a) {
        List<Account> Accounts=a.listAcc();
        System.out.println("----------------------------------------------");
        Accounts.forEach(ac->{
            System.out.printf("| %-10s|| %-10s|| %-11.2f|\n",ac.getAccountNumber(),ac.getAccountType(),ac.getBalance());
        });
        System.out.println("----------------------------------------------");
    }

    //amount deposition function
    private static void depositAmount(Scanner sc, BankService accountService) {
        System.out.print("plz enter your account number: ");
        String acNumber=sc.nextLine().trim();
        System.out.print("plz enter the amount you want to deposit");
        double deposit=Double.parseDouble(sc.nextLine());
        System.out.println("Any note to be attached (leave empty id not):");
        String note=sc.nextLine();

        if (deposit>=0) {
            String result=accountService.depositAmount(acNumber, deposit,note );
            System.out.println(result);
        }
        else {
            System.out.println("plz enter valid amount");
        }
    }



}
