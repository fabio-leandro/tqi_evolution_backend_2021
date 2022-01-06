package br.com.fabio.bankloanapi.services;

import br.com.fabio.bankloanapi.dtos.CustomerDto;
import br.com.fabio.bankloanapi.entities.Customer;
import br.com.fabio.bankloanapi.exceptions.CustomerNotFoundException;
import br.com.fabio.bankloanapi.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

        public List<CustomerDto> findAll(){
                List<Customer> customerList = customerRepository.findAll();
                List<CustomerDto> customerDtoList =
                        customerList.stream().map( c -> modelMapper.map(c, CustomerDto.class))
                                .collect(Collectors.toList());
                return customerDtoList;
        }

        public CustomerDto findById(Long id) throws CustomerNotFoundException {
               return modelMapper.map(customerRepository.findById(id)
                       .orElseThrow(CustomerNotFoundException::new), CustomerDto.class);
        }

        public CustomerDto updateById(Long id, CustomerDto customerDto) throws CustomerNotFoundException {
                findById(id);
                Customer customer = customerRepository.save(modelMapper.map(customerDto, Customer.class));
                return modelMapper.map(customer,CustomerDto.class);
        }

        public void deleteById(Long id) throws CustomerNotFoundException {
                findById(id);
                customerRepository.deleteById(id);
        }

}
