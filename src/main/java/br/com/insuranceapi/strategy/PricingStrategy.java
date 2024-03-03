package br.com.insuranceapi.strategy;

public interface PricingStrategy {

    Integer getPriceCategory(Double price);

    String choosePrice();
}
