package br.com.fabio.loanapi.controllers.validators;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class LoanValidationsErrors {

    public Map<String, Object> callLoanValidatorsException(MethodArgumentNotValidException ex){

        Map<String, Object> errors = new HashMap<>();

        Instant timestamp = Instant.now();
        Integer status = HttpStatus.BAD_REQUEST.value();
        String errorDescription = "The field cannot be validated";
        String path = "api/v1/loans";

        errors.put("timestamp", timestamp);
        errors.put("status", status);
        errors.put("error", errorDescription);
        errors.put("path", path);

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });


        return errors;
    }

}
