package br.com.insuranceapi.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsuranceDTOTest {

    @Test
    void testConstructor(){

        InsuranceDTO insurance = new InsuranceDTO("Basic", 2000.0);

        assertEquals(2000.0, insurance.getCost());
        assertEquals("Basic", insurance.getType());

    }
}
