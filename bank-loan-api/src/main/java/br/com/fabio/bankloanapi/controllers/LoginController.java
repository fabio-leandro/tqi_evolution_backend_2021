package br.com.fabio.bankloanapi.controllers;

import br.com.fabio.bankloanapi.controllers.validators.LoginValidationsErrors;
import br.com.fabio.bankloanapi.dtos.LoginDto;
import br.com.fabio.bankloanapi.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("api/v1/logins")
public class LoginController {

        @Autowired
        public LoginService loginService;

        @PostMapping
        public ResponseEntity<LoginDto> save (@RequestBody @Valid LoginDto loginDto){
            return ResponseEntity.status(HttpStatus.CREATED).body(loginService.save(loginDto));
        }

        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public Map<String, Object> callLoginValidationException(MethodArgumentNotValidException ex){
                return new LoginValidationsErrors().callLoginValidatorsException(ex);
        }


}
