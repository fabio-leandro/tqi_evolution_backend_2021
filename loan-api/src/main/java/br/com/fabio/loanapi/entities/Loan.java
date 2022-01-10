package br.com.fabio.loanapi.entities;

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

    @Column(nullable = false)
    private BigDecimal loanValue;
    @Column(nullable = false)
    private int numberPayments;
    @Column(nullable = false)
    private LocalDate firstPayment;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


}
