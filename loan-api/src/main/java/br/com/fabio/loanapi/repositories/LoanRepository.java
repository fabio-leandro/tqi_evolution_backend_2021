package br.com.fabio.loanapi.repositories;

import br.com.fabio.loanapi.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan,Long> {

    List<Loan> findAllByCustomerId(Long idCustomer);

    Optional<Loan> findByIdAndCustomerId(Long idLoan, Long idCustomer);
}
