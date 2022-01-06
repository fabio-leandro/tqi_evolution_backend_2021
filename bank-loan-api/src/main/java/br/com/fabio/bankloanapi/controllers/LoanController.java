package br.com.fabio.bankloanapi.controllers;

import br.com.fabio.bankloanapi.dtos.DetailsLoanDto;
import br.com.fabio.bankloanapi.dtos.LoanDto;
import br.com.fabio.bankloanapi.exceptions.CustomerNotFoundException;
import br.com.fabio.bankloanapi.exceptions.LoanNotFoundException;
import br.com.fabio.bankloanapi.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/loans")
public class LoanController {

    @Autowired
    public LoanService loanService;

    @PostMapping("/{idCustomer}")
    public ResponseEntity<LoanDto> save(@RequestBody LoanDto loanDto, @PathVariable Long idCustomer)
            throws CustomerNotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(loanService.save(loanDto, idCustomer));
    }

    @GetMapping
    public ResponseEntity<List<LoanDto>> findAllByCustomerId(@RequestParam Long idCustomer){
        return ResponseEntity.status(HttpStatus.OK).body(loanService.findAllByCustomerId(idCustomer));
    }

    @GetMapping("/details")
    public ResponseEntity<DetailsLoanDto> getDetailsLoan(@RequestParam Long idLoan,
                                                         @RequestParam Long idCustomer) throws LoanNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(loanService.findByIdAndCustomerId(idLoan,idCustomer));
    }

}
