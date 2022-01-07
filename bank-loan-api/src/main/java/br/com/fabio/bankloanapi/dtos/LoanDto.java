package br.com.fabio.bankloanapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanDto {

    private Long id;
    @NotNull(message = "The loan value cannot be null.")
    private BigDecimal loanValue;
    @NotNull(message = "The number of payments cannot be null.")
    @Min(value = 1, message = "The number of payments cannot be zero.")
    @Max(value = 60, message = "The number of payments cannot be bigger than 60 payments.")
    private int numberPayments;
    @NotEmpty(message = "The date of first payment cannot be blank.")
    @Size(min = 10, max = 10, message = "The date of first payment is invalid.")
    @FutureOrPresent
    private LocalDate firstPayment;


}
