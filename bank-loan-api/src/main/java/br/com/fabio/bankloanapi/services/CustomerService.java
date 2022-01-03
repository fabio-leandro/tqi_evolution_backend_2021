package br.com.fabio.bankloanapi.services;

import br.com.fabio.bankloanapi.dtos.CustomerDto;
import br.com.fabio.bankloanapi.entities.Customer;
import br.com.fabio.bankloanapi.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

        @Autowired
        CustomerRepository customerRepository;

        @Autowired
        ModelMapper modelMapper;

        public CustomerDto save(CustomerDto customerDto){
            Customer customer = modelMapper.map(customerDto, Customer.class);
            return modelMapper.map(customerRepository.save(customer),CustomerDto.class);
        }


}
