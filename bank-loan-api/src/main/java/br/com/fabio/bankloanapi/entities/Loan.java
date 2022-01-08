package br.com.fabio.bankloanapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "The first payment cannot be null or after 90 days today.")
    private LocalDate firstPayment;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


}
