package br.com.fabio.bankloanapi.controllers;

import br.com.fabio.bankloanapi.controllers.validators.CustomerValidationsErrors;
import br.com.fabio.bankloanapi.dtos.CustomerDto;
import br.com.fabio.bankloanapi.exceptions.CustomerNotFoundException;
import br.com.fabio.bankloanapi.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

        @Autowired
        CustomerService customerService;

        @PostMapping
        public ResponseEntity<CustomerDto> save(@Valid @RequestBody CustomerDto customerDto){
            return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customerDto));
        }

        @GetMapping
        public ResponseEntity<List<CustomerDto>> findAll(){
                return ResponseEntity.status(HttpStatus.OK).body(customerService.findAll());
        }

        @GetMapping("/{id}")
        public ResponseEntity<CustomerDto> findById(@PathVariable Long id) throws CustomerNotFoundException {
                return ResponseEntity.status(HttpStatus.OK).body(customerService.findById(id));
        }

        @PutMapping("/{id}")
        public ResponseEntity<CustomerDto> updateById(@PathVariable Long id, @RequestBody CustomerDto customerDto)
                                                        throws CustomerNotFoundException {
                return ResponseEntity.status(HttpStatus.OK).body(customerService.updateById(id,customerDto));
        }

        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteById(@PathVariable Long id) throws CustomerNotFoundException {
                customerService.deleteById(id);
        }

        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public Map<String, Object> callCustomerValidationException(MethodArgumentNotValidException ex){
                return new CustomerValidationsErrors().callCustomerValidatorsException(ex);
        }


}
