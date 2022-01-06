package br.com.fabio.bankloanapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private BigDecimal loanValue;
    private int numberPayments;
    private LocalDate firstPayment;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
