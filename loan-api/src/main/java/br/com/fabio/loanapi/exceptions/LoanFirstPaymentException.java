package br.com.fabio.loanapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LoanFirstPaymentException extends Exception{

    public LoanFirstPaymentException() {
        super("The first payment must be before 90 days of today!");
    }
}
