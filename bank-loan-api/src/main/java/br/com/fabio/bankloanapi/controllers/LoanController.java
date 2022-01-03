package br.com.fabio.bankloanapi.controllers;

import br.com.fabio.bankloanapi.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/loans")
public class LoanController {

    @Autowired
    public LoanService loanService;

}
