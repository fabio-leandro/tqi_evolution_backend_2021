package br.com.fabio.bankloanapi.controllers;

import br.com.fabio.bankloanapi.dtos.LoginDto;
import br.com.fabio.bankloanapi.entities.Customer;
import br.com.fabio.bankloanapi.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/logins")
public class LoginController {

        @Autowired
        public LoginService loginService;

        @PostMapping
        public ResponseEntity<LoginDto> save (@RequestBody LoginDto loginDto){
            return ResponseEntity.status(HttpStatus.CREATED).body(loginService.save(loginDto));
        }


}
