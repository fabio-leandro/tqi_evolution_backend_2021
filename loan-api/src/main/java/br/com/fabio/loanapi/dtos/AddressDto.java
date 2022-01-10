package br.com.fabio.loanapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private Long id;
    @NotBlank(message = "The cep field cannot be blank.")
    @Size(min = 9, max = 9, message = "The informed cep is not valid.")
    private String cep;
    @NotBlank(message = "The street field cannot be blank.")
    private String street;
    @NotBlank(message = "The number field cannot be blank.")
    private String number;

    private String complement;

    @NotBlank(message = "The district field cannot be blank.")
    private String district;
    @NotBlank(message = "The city field cannot be blank.")
    private String city;
    @NotBlank(message = "The state field cannot be blank.")
    private String state;
    @NotBlank(message = "The country field cannot be blank.")
    private String country;

}
