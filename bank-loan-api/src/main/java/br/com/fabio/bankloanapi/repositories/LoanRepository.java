package br.com.fabio.bankloanapi.repositories;

import br.com.fabio.bankloanapi.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan,Long> {
}
