package br.com.fabio.loanapi.controllers;


import br.com.fabio.loanapi.dtos.LoginDto;
import br.com.fabio.loanapi.dtos.ValidateLoginDto;
import br.com.fabio.loanapi.exceptions.LoginNotFoundException;
import br.com.fabio.loanapi.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/logins")
public class CustomerControllerLogin {

    @Autowired
    LoginService loginService;

    @GetMapping("/validateLogin")
    public ResponseEntity<Map<Long, String>> validateLogin(@RequestBody ValidateLoginDto validateLoginDto)
            throws LoginNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(loginService.validateLogin(validateLoginDto));
    }

    @PutMapping("/updateLogin")
    public ResponseEntity<String> updateLogin(@RequestBody LoginDto loginDto, @RequestParam String email)
            throws LoginNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(loginService.updateLogin(loginDto,email));
    }

}
