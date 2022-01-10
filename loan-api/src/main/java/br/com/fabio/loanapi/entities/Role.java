package br.com.fabio.loanapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "tb_roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String getAuthority() {
        return this.roleName;
    }
}
