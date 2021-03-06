package br.com.fabio.loanapi.services;

import br.com.fabio.loanapi.dtos.DetailsLoanDto;
import br.com.fabio.loanapi.dtos.LoanDto;
import br.com.fabio.loanapi.entities.Loan;
import br.com.fabio.loanapi.exceptions.CustomerNotFoundException;
import br.com.fabio.loanapi.exceptions.LoanFirstPaymentException;
import br.com.fabio.loanapi.exceptions.LoanNotFoundException;
import br.com.fabio.loanapi.repositories.CustomerRepository;
import br.com.fabio.loanapi.repositories.LoanRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ModelMapper modelMapper;

    public LoanDto save(LoanDto loanDto, Long idCostumer) throws CustomerNotFoundException, LoanFirstPaymentException {
        if(loanDto.getFirstPayment().isAfter(LocalDate.now().plusDays(90)))
            throw new LoanFirstPaymentException();
        Loan loan = modelMapper.map(loanDto,Loan.class);
        loan.setCustomer(customerRepository.findById(idCostumer).orElseThrow(CustomerNotFoundException::new));
        loanRepository.save(loan);
        return modelMapper.map(loan,LoanDto.class);
    }

    public List<LoanDto> findAllLoans(){
        List<Loan> listLoan = loanRepository.findAll();
        return listLoan.stream().map(l -> modelMapper.map(l, LoanDto.class))
                .collect(Collectors.toList());
    }

    public List<LoanDto> findAllByCustomerId(Long idCostumer){
        List<Loan> listLoan = loanRepository.findAllByCustomerId(idCostumer);
        return listLoan.stream().map(l -> modelMapper.map(l,LoanDto.class))
                .collect(Collectors.toList());
    }

    public DetailsLoanDto findByIdAndCustomerId(Long idLoan, Long idCustomer) throws LoanNotFoundException {
        Loan loan = loanRepository.findByIdAndCustomerId(idLoan, idCustomer)
                                        .orElseThrow(LoanNotFoundException::new);
        DetailsLoanDto detailsLoanDto = modelMapper.map(loan,DetailsLoanDto.class);
        detailsLoanDto.setEmail(loan.getCustomer().getLogin().getEmail());
        detailsLoanDto.setIncome(loan.getCustomer().getIncome());
        return detailsLoanDto;
    }
}
