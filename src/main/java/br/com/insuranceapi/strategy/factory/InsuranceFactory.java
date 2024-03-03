package br.com.insuranceapi.strategy.factory;

import br.com.insuranceapi.strategy.InsuranceStrategy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class InsuranceFactory {

    private final Map<Integer, InsuranceStrategy> strategies = new HashMap<>();

    public InsuranceFactory(Set<InsuranceStrategy> strategySet){

        strategySet.forEach(s -> strategies.put(s.getTypeVehicle(), s));
    }

    public InsuranceStrategy getStrategy(Integer vehicleType){

        InsuranceStrategy strategy = strategies.get(vehicleType);

        return strategy;
    }

}
