package br.com.fabio.loanapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends Exception{

    public CustomerNotFoundException() {
        super("Customer not found with this identifier!");
    }
}
