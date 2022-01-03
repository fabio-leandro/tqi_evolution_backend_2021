package br.com.fabio.bankloanapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private Long id;
    private String cep;
    private String street;
    private String number;
    private String complement;
    private String district;
    private String city;
    private String state;
    private String country;

}
