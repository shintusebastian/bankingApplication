package co.pragra.demo.api;

import co.pragra.demo.entity.Account;
import co.pragra.demo.entity.AccountType;
import co.pragra.demo.entity.ErrorResponse;
import co.pragra.demo.exceptions.AccountNotFoundException;
import co.pragra.demo.services.AccountService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@Controller
//@ResponseBody both the above annotations can be replaced with a single annotation @RestController
@RestController
//@RequestMapping("/api")
public class AccountApi {
    private AccountService service;

    public AccountApi(AccountService service) {
        this.service = service;
    }

    /*
     * Expose all accounts*/
//    @GetMapping(value = "/api/account")
////    @GetMapping(value="/api/account", produces = MediaType.APPLICATION_XML_VALUE)// to add xml.
////    // by default the value will be json.
//    public List<Account> getAll() {
//        return service.getAll();
//    }

    @GetMapping(value = "/api/account")
//    @GetMapping(value="/api/account", produces = MediaType.APPLICATION_XML_VALUE)// to add xml.
//    // by default the value will be json.
    public List<Account> getAll(@RequestParam(value = "accountType", required = false/*means we
    don't have to pass it*/) AccountType accountType) {
        if (accountType != null) {
            return service.getAll().stream().filter(a -> a.getAccountType() == accountType).collect(Collectors.toList());
        }
        return service.getAll();
    }


    @PostMapping("/api/account")
    public Account createAccount(@RequestBody Account account) {
        return service.createAccount(account);
    }

    //    @GetMapping("/api/account/{id}")
//    public Account getById(@PathVariable("id") int id) {
//        return service.getById(id).get();
//    }
    @GetMapping("/api/account/{id}")//to avoid someone passing the null id to the method we wrap it
    //with Integer type. We cannot wrap it with primitives.
    public ResponseEntity<?> getById(@PathVariable("id") Optional<Integer> id) {// we put a ? mark as we don't
        // know what we are returning
        Optional<Account> account = service.getById(id.orElseThrow(() -> new IllegalArgumentException("ID Can't be null")));
        return ResponseEntity.ok(account.orElseThrow(AccountNotFoundException::new));
        //this is known as constructor reference

//    if(account.isPresent()){
//        return ResponseEntity.status(200).header("X-Producer","Shintu Sebastian")
//                .body(account.get());
//    }
//    return ResponseEntity.status(404).header("X-Fault", "NO DATA")
//            .body(ErrorResponse.builder().code(10001).message("NO DATA FOUND").
//            applicationId("DL1").time(Instant.now()).build());


    }

    @PutMapping("/api/account")
    public Account updateAccount(@RequestBody Account account) {
        return service.updateAccount(account);
    }
}
