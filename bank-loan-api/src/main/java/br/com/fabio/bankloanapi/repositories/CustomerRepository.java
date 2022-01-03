package br.com.fabio.bankloanapi.repositories;

import br.com.fabio.bankloanapi.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
