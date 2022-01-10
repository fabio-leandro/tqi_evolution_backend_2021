package br.com.fabio.loanapi.dtos;

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
    @DecimalMin(value = "0.01", message = "The loan value is invalid.")
    private BigDecimal loanValue;
    @NotNull(message = "The number of payments cannot be null.")
    @Min(value = 1, message = "The number of payments cannot be zero.")
    @Max(value = 60, message = "The number of payments cannot be bigger than 60 payments.")
    private int numberPayments;

    @FutureOrPresent(message = "First payment date is invalid.")
    private LocalDate firstPayment;


}
