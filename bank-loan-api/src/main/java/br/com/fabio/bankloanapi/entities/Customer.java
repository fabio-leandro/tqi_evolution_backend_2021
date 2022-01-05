package br.com.fabio.bankloanapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String cpf;
    private String rg;
    private BigDecimal income;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private Address address = new Address();

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private Login login;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Loan> loan;

}
