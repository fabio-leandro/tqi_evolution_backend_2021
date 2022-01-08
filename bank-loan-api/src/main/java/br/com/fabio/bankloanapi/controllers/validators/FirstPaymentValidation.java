package br.com.fabio.bankloanapi.controllers.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FirstPaymentValidationImpl.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface FirstPaymentValidation {

    String message() default "The first payment cannot be after 90 days of today.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
