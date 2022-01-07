package br.com.fabio.bankloanapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private Long id;
    @NotBlank(message = "The cep field cannot be blank.")
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
