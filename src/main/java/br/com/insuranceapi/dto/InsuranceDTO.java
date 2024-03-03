package br.com.insuranceapi.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class InsuranceDTO {

    private String type;
    private double cost;
}
