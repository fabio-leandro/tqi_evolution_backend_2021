package br.com.fabio.bankloanapi.dtos;

import br.com.fabio.bankloanapi.entities.enums.LoginType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    private Long id;
    @NotEmpty(message = "The email field cannot be blank.")
    private String email;
    @NotEmpty(message = "The password field cannot be blank.")
    private String password;
    @NotEmpty(message = "The login type field cannot be blank.")
    private LoginType loginType;

}
