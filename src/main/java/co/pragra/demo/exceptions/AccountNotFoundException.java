package co.pragra.demo.exceptions;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(String message) {
        super(message);
    }

    public AccountNotFoundException() {
        this("No matching Account for this id");
    }

}
