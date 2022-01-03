package br.com.fabio.bankloanapi.services;

import br.com.fabio.bankloanapi.dtos.LoginDto;
import br.com.fabio.bankloanapi.entities.Customer;
import br.com.fabio.bankloanapi.entities.Login;
import br.com.fabio.bankloanapi.repositories.LoginRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    public LoginRepository loginRepository;

    @Autowired
    public ModelMapper modelMapper;

    public LoginDto save(LoginDto loginDto){
        Login login = modelMapper.map(loginDto, Login.class);
        return modelMapper.map(loginRepository.save(login),LoginDto.class);
    }
}
