package br.com.fabio.loanapi.services;

import br.com.fabio.loanapi.dtos.LoginDto;
import br.com.fabio.loanapi.dtos.ValidateLoginDto;
import br.com.fabio.loanapi.entities.Login;
import br.com.fabio.loanapi.exceptions.LoginNotFoundException;
import br.com.fabio.loanapi.repositories.LoginRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    ModelMapper modelMapper;

    public Map<Long,String> validateLogin(ValidateLoginDto validateLoginDto) throws LoginNotFoundException {
        Login login = loginRepository.findByEmail(validateLoginDto.getEmail())
                .orElseThrow(LoginNotFoundException::new);
        Map<Long,String> loginCustomer = new HashMap<>();
        loginCustomer.put(login.getId(), login.getEmail());
        return loginCustomer;
    }

    public String updateLogin(LoginDto loginDto, String email) throws LoginNotFoundException {
        loginRepository.findByEmail(email).orElseThrow(LoginNotFoundException::new);
        Login login = modelMapper.map(loginDto,Login.class);
        login.setPassword(new BCryptPasswordEncoder().encode(login.getPassword()));
        return "The login was updated";
    }
}
