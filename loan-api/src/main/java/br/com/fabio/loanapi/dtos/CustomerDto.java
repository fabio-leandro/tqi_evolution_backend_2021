package br.com.fabio.loanapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private Long id;
    @NotBlank(message = "The name field cannot be blank.")
    @Size(min = 2, message = "The name field is invalid.")
    private String name;
    @NotBlank(message = "The cpf field cannot be blank.")
    @CPF(message = "The informed CPF is not valid. ")
    private String cpf;
    @NotBlank(message = "The rg field cannot be blank")
    private String rg;
    @NotNull(message = "The income field cannot be null.")
    @DecimalMin(value = "0.01", message = "The income field is invalid.")
    private BigDecimal income;

    @Valid
    @NotNull(message = "The field cannot be null")
    private AddressDto address;

    @Valid
    @NotNull(message = "The field cannot be null")
    private LoginDto login;

}
