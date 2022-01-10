package br.com.fabio.bankloanapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    private Long id;
    @NotBlank(message = "The email field cannot be blank.")
    @Email(message = "The informed email is not valid.")
    private String email;
    @NotBlank(message = "The password field cannot be blank.")
    private String password;


}
