package repository;

import domain.Account;
import domain.Customer;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class customerRepository {
    public static final Map<String, Customer> customerStorage=new HashMap<>();

    public void save( Customer a){
        customerStorage.put(a.getCustomerEmail(),a);
    }

    public Optional<Customer> findById(String accName){
        return Optional.ofNullable(customerStorage.get(accName));
    }

}
