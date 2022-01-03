package br.com.fabio.bankloanapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String cep;
    private String street;
    private String number;
    private String complement;
    private String district;
    private String city;
    private String state;
    private String country;

    @OneToOne(mappedBy = "address")
    private Customer customer;

}
