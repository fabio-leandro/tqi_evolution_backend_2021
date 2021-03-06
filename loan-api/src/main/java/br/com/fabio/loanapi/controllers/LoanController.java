package br.com.fabio.loanapi.controllers;

import br.com.fabio.loanapi.controllers.validators.LoanValidationsErrors;
import br.com.fabio.loanapi.dtos.DetailsLoanDto;
import br.com.fabio.loanapi.dtos.LoanDto;
import br.com.fabio.loanapi.exceptions.CustomerNotFoundException;
import br.com.fabio.loanapi.exceptions.LoanFirstPaymentException;
import br.com.fabio.loanapi.exceptions.LoanNotFoundException;
import br.com.fabio.loanapi.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/loans")
public class LoanController {

    @Autowired
    public LoanService loanService;

    @PostMapping("/requestLoan/{idCustomer}")
    public ResponseEntity<LoanDto> save(@RequestBody @Valid LoanDto loanDto, @PathVariable Long idCustomer)
            throws CustomerNotFoundException, LoanFirstPaymentException {
        return ResponseEntity.status(HttpStatus.CREATED).body(loanService.save(loanDto, idCustomer));
    }

    @GetMapping("/listAllLoans")
    public ResponseEntity<List<LoanDto>> findAllLoans(){
        return ResponseEntity.status(HttpStatus.OK).body(loanService.findAllLoans());
    }

    @GetMapping("/listAllLoansByCustomer")
    public ResponseEntity<List<LoanDto>> findAllByCustomerId(@RequestParam Long idCustomer){
        return ResponseEntity.status(HttpStatus.OK).body(loanService.findAllByCustomerId(idCustomer));
    }

    @GetMapping("/detailsLoanByCustomer")
    public ResponseEntity<DetailsLoanDto> getDetailsLoan(@RequestParam Long idLoan,
                                                         @RequestParam Long idCustomer) throws LoanNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(loanService.findByIdAndCustomerId(idLoan,idCustomer));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> callLoanValidationException(MethodArgumentNotValidException ex){
        return new LoanValidationsErrors().callLoanValidatorsException(ex);
    }

}
