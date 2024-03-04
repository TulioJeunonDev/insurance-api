package br.com.insuranceapi.dto;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;

import static br.com.insuranceapi.utils.ConstantsUtils.NAME_MANDATORY;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    @NotBlank(message = NAME_MANDATORY)
    private String name;

    @CPF
    private String cpf;

    @Min(value = 18)
    @Max(value = 100)
    private int age;

    @Pattern(regexp = "^.{2}$")
    private String location;

    @Min(value = 10000)
    @Max(value = 1000000)
    private Double vehiclePrice;
}
