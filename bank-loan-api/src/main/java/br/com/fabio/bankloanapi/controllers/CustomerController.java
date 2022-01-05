package br.com.fabio.bankloanapi.controllers;

import br.com.fabio.bankloanapi.dtos.CustomerDto;
import br.com.fabio.bankloanapi.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

        @Autowired
        CustomerService customerService;

        @PostMapping
        public ResponseEntity<CustomerDto> save(@RequestBody CustomerDto customerDto){
            return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customerDto));
        }

}
