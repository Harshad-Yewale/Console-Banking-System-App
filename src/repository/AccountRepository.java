package repository;

import domain.Account;

import java.util.*;

public class AccountRepository {
    public static final Map<String,Account> AccountStorage=new HashMap<>();

    public void save( Account a){
        AccountStorage.put(a.getAccountNumber(),a);
    }

    public List<Account> findAll(){
        return new ArrayList<>(AccountStorage.values());
    }

    public Optional<Account> findById(String accId){
        return Optional.ofNullable(AccountStorage.get(accId));
    }
}
