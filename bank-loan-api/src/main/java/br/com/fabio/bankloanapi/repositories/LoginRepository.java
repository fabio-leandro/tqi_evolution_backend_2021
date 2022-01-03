package br.com.fabio.bankloanapi.repositories;

import br.com.fabio.bankloanapi.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login,Long> {
}
