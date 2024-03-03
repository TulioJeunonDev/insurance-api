package br.com.insuranceapi.strategy.factory;

import br.com.insuranceapi.strategy.PricingStrategy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class PricingFactory {

    private final Map<String, PricingStrategy> strategies = new HashMap<>();

    public PricingFactory(Set<PricingStrategy> strategySet){

        strategySet.forEach(s -> strategies.put(s.choosePrice(), s));
    }

    public PricingStrategy getStrategy(String vehicleType){

        PricingStrategy strategy = strategies.get(vehicleType);

        return strategy;
    }
}
