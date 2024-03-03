package br.com.insuranceapi.strategy.impl;

import br.com.insuranceapi.strategy.PricingStrategy;

import static br.com.insuranceapi.utils.ConstantsUtils.FIRST;

public class FirstPricing implements PricingStrategy {

    @Override
    public Integer getPriceCategory(Double price) {
        if (price <= 70000) {
            return 1;
        } else if (price > 70000 && price < 100000) {
            return 2;
        } else {
            return 3;
        }
    }

    @Override
    public String choosePrice() {
        return FIRST;
    }
}
