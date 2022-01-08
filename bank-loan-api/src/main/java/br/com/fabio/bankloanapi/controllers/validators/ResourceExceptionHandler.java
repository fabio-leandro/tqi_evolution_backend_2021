package br.com.fabio.bankloanapi.controllers.validators;

import br.com.fabio.bankloanapi.controllers.errors.MessageError;
import br.com.fabio.bankloanapi.exceptions.CustomerNotFoundException;
import br.com.fabio.bankloanapi.exceptions.LoanNotFoundException;
import br.com.fabio.bankloanapi.exceptions.LoginNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<MessageError> callCustomerNotFound(CustomerNotFoundException e, HttpServletRequest request){

        MessageError err = new MessageError();

        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setError("Resource not found");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);

    }

    @ExceptionHandler(LoanNotFoundException.class)
    public ResponseEntity<MessageError> callLoanNotFound(LoanNotFoundException e, HttpServletRequest request){

        MessageError err = new MessageError();

        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setError("Resource not found");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);

    }

    @ExceptionHandler(LoginNotFoundException.class)
    public ResponseEntity<MessageError> callLoginNotFound(LoginNotFoundException e, HttpServletRequest request){

        MessageError err = new MessageError();

        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setError("Resource not found");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);

    }


}
