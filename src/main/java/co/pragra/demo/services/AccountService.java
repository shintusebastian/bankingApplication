package co.pragra.demo.services;

import co.pragra.demo.entity.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private final List<Account> accounts=new ArrayList<>();

    private static int counter=10000;

    public Account createAccount(Account account){
        account.setAccountId(counter++);
        accounts.add(account);
        return account;
    }
    public Optional<Account> getById(int id){//we may not have a value, so we have changed it to optional.
       return accounts.stream().filter(a->a.getAccountId()==id).findFirst();
    }
    public Account updateAccount(Account account){
        Optional<Account> byId = getById(account.getAccountId());
        if(byId.isPresent()){
            accounts.remove(byId.get());
            accounts.add(account);
        }
        return account;
    }

    public List<Account> getAll() {
        return accounts;
    }
}
