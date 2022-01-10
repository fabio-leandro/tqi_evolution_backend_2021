package br.com.fabio.bankloanapi.repositories;

import br.com.fabio.bankloanapi.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login,Long> {

    Optional<Login> findByEmail(String email);
}
