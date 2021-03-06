package br.com.fabio.loanapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailsLoanDto {

    private Long id;
    private BigDecimal loanValue;
    private int numberPayments;
    private LocalDate firstPayment;
    private String email;
    private BigDecimal income;

}
