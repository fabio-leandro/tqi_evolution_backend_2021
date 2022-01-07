package br.com.fabio.bankloanapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LoginNotFoundException extends Exception{

    public LoginNotFoundException() {
        super("Loan not found with this identifier!");
    }
}
