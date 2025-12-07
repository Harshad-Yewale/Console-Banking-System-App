package repository;

import domain.Account;
import domain.Transactions;
import domain.Type;

import java.time.LocalDateTime;
import java.util.*;

public class transactionRepository {

    public final Map<String, List<Transactions>> txbyAccount=new HashMap<>();


    public void add(Transactions tr) {
       List <Transactions> list=  txbyAccount.computeIfAbsent(tr.getAccountNumber(),k->new ArrayList<>());
       list.add(tr);
    }
    public List<Transactions> findByAccount(String acc){
        return new ArrayList<>(txbyAccount.getOrDefault(acc,Collections.emptyList()));
    }
}
