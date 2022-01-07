package br.com.fabio.bankloanapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private String id;
    @NotBlank(message = "The name field cannot be blank.")
    @Size(min = 2, message = "The name field is invalid.")
    private String name;
    @NotEmpty(message = "The cpf field cannot be blank.")
    @Size(min = 11,max = 11, message = "The cpf must have 11 characters.")
    private String cpf;
    @NotBlank(message = "The rg field cannot be blank")
    private String rg;
    @NotNull(message = "The income field cannot be null.")
    @DecimalMin(value = "0.01", message = "The income field is invalid.")
    private BigDecimal income;
    @NotNull(message = "The field cannot be null")
    private AddressDto address;
    @NotNull(message = "The field cannot be null")
    private LoginDto login;

}
