package br.com.fabio.bankloanapi.repositories;

import br.com.fabio.bankloanapi.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
