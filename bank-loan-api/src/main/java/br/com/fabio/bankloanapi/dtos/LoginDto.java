package br.com.fabio.bankloanapi.dtos;

import br.com.fabio.bankloanapi.entities.enums.LoginType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    private Long id;
    private String email;
    private String password;
    private LoginType loginType;

}
