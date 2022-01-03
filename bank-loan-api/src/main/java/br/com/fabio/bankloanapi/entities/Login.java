package br.com.fabio.bankloanapi.entities;


import br.com.fabio.bankloanapi.entities.enums.LoginType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_logins")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String email;
    private String password;
    private LoginType loginType;

    @OneToOne(mappedBy = "login", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Customer customer;

}
