package co.pragra.demo.services;

import co.pragra.demo.entity.Account;
import co.pragra.demo.repo.AccountRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
//    private final List<Account> accounts=new ArrayList<>();
//
//    private static int counter=10000;
    //we don't need this list anymore. Now on, we are using the Account Repo

    private AccountRepo repo;

    public AccountService(AccountRepo repo) {
        this.repo = repo;
    }

//}// we have autowired accounts using a constructor

    public Account createAccount(Account account){
//        account.setAccountId(counter++);
//        accounts.add(account); we don't need this logic anymore
        return repo.save(account);
        //this method is coming from JPA(java persistence api)


    }
    public Optional<Account> getById(int id){//we may not have a value, so we have changed it to optional.
      // return accounts.stream().filter(a->a.getAccountId()==id).findFirst();
        return repo.findById(id);
    }
    public List<Account> getAccountByName(String name){
 return repo.findAllByAccountNameContainingIgnoreCase(name);
    }


    public Account updateAccount(Account account){
//        Optional<Account> byId = getById(account.getAccountId());
//        if(byId.isPresent()){
//            accounts.remove(byId.get());
//            accounts.add(account);
//        }
//        return account;
        return repo.save(account); //save will do the same thing as createAccount will do.
    }

    public List<Account> getAll() {
//        return accounts;
        return repo.findAll();
    }
}
