package br.com.insuranceapi.strategy.impl;

import br.com.insuranceapi.dto.CustomerDTO;
import br.com.insuranceapi.dto.InsuranceDTO;
import br.com.insuranceapi.strategy.InsuranceStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static br.com.insuranceapi.utils.ConstantsUtils.*;

public class HighVehiclePrice implements InsuranceStrategy {

    @Override
    public List<InsuranceDTO> getInsuranceByCustomer(CustomerDTO customer) {
        List<InsuranceDTO> insuranceList = new ArrayList<>();

        insuranceList.add(InsuranceDTO.builder().cost(1000).type(BASIC).build());

        if(customer.getAge() < 30)
            insuranceList.add(InsuranceDTO.builder().cost(2000).type(PARTIAL).build());

        insuranceList.add(InsuranceDTO.builder().cost(3000).type(TOTAL).build());

        return insuranceList;
    }

    @Override
    public Integer getTypeVehicle() {
        return 3;
    }
}
