package br.com.fabio.bankloanapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanDto {

    private Long id;
    private BigDecimal loanValue;
    private int numberPayments;
    private LocalDate firstPayment;


}
