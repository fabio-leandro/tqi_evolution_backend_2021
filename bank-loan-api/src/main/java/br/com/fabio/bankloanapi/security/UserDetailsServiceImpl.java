package br.com.fabio.bankloanapi.security;

import br.com.fabio.bankloanapi.entities.Login;
import br.com.fabio.bankloanapi.exceptions.LoginNotFoundException;
import br.com.fabio.bankloanapi.repositories.LoginRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Login login = loginRepository.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("The email was not found."));
        return login;
    }
}
