package br.com.fabio.loanapi.repositories;

import br.com.fabio.loanapi.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
