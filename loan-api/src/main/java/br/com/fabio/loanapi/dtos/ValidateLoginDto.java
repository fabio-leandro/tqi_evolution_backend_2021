package br.com.fabio.loanapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidateLoginDto {

    @NotBlank(message = "It must be informed an email valid.")
    private String email;
    @NotBlank(message = "It must be informed an email valid.")
    private String password;

}
