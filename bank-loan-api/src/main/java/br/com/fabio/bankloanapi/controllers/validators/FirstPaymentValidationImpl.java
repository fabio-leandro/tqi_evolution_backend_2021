package br.com.fabio.bankloanapi.controllers.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class FirstPaymentValidationImpl implements ConstraintValidator<FirstPaymentValidation, LocalDate> {
    @Override
    public void initialize(FirstPaymentValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
            LocalDate futureDate = LocalDate.now().plusDays(90);
            int dates = localDate.compareTo(futureDate);
            if(dates > 0)
                localDate = null;
                return false;

    }
}
