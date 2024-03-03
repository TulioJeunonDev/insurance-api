package br.com.insuranceapi.strategy;

import br.com.insuranceapi.dto.CustomerDTO;
import br.com.insuranceapi.dto.InsuranceDTO;

import java.util.List;

public interface InsuranceStrategy {

    List<InsuranceDTO> getInsuranceByCustomer(CustomerDTO customer);

    Integer getTypeVehicle();


}
