package br.com.insuranceapi.dto;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;

import static br.com.insuranceapi.utils.ConstantsUtils.*;

@Builder
@Getter
@AllArgsConstructor
public class CustomerDTO {

    @NotBlank(message = NAME_NOT_NULL)
    private String name;

    @CPF
    private String cpf;

    @NotNull(message = AGE_NOT_NULL)
    @Min(value = 18, message = AGE_MIN)
    private Integer age;

    private String location;

    @NotBlank(message = PRICE_NOT_NULL)
    @DecimalMin(value = MIN_PRICE, message = MIN_PRICE_MESSAGE)
    private Double vehiclePrice;
}
