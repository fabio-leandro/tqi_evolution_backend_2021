package br.com.fabio.bankloanapi.services;

import br.com.fabio.bankloanapi.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    @Autowired
    public LoanRepository loanRepository;
}
