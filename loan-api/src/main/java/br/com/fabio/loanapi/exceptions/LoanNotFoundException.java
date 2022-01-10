package br.com.fabio.loanapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LoanNotFoundException extends Exception {

    public LoanNotFoundException() {
        super("Loan not found with this identifier!");
    }
}
