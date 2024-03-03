package br.com.insuranceapi.service;

import br.com.insuranceapi.dto.CustomerDTO;
import br.com.insuranceapi.dto.CustomerInsuranceDTO;
import br.com.insuranceapi.dto.InsuranceDTO;
import br.com.insuranceapi.strategy.factory.InsuranceFactory;
import br.com.insuranceapi.strategy.factory.PricingFactory;
import br.com.insuranceapi.strategy.impl.FirstPricing;
import br.com.insuranceapi.strategy.impl.HighVehiclePrice;
import br.com.insuranceapi.strategy.impl.LowerVehiclePrice;
import br.com.insuranceapi.strategy.impl.MediumVehiclePrice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static br.com.insuranceapi.utils.ConstantsUtils.FIRST;

@Service
public class CustomerInsuranceService {
    private final InsuranceFactory insuranceFactory = new InsuranceFactory(Set.of(new MediumVehiclePrice(), new HighVehiclePrice(), new LowerVehiclePrice()));
    private final PricingFactory pricingFactory = new PricingFactory(Set.of(new FirstPricing()));
    public CustomerInsuranceDTO findInsuranceByCustomer(CustomerDTO customer){

        Integer vehicleType = pricingFactory.getStrategy(FIRST).getPriceCategory(customer.getVehiclePrice());

        List<InsuranceDTO> insuranceList = insuranceFactory.getStrategy(vehicleType).getInsuranceByCustomer(customer);

        return CustomerInsuranceDTO.builder().name(customer.getName()).insurances(insuranceList).build();

    }

}
