package br.com.insuranceapi.dto;

import lombok.*;

import java.util.Arrays;
import java.util.List;

import static br.com.insuranceapi.utils.ConstantsUtils.BASIC;

@Builder
@Getter
@AllArgsConstructor
public class CustomerInsuranceDTO {

    private String name;
    private List<InsuranceDTO> insurances;
}
