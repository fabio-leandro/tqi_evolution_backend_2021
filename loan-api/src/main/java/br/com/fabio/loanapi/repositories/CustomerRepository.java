package br.com.fabio.loanapi.repositories;

import br.com.fabio.loanapi.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
