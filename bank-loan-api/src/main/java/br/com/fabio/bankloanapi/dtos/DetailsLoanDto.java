package br.com.fabio.bankloanapi.dtos;

import br.com.fabio.bankloanapi.entities.Customer;
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
