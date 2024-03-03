package br.com.insuranceapi.dto;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerInsuranceDTOTest {

    @Test
    void testConstructor(){

        CustomerInsuranceDTO customerInsurance = new CustomerInsuranceDTO("John", Collections.emptyList());

        assertEquals(Collections.emptyList(), customerInsurance.getInsurances());
        assertEquals("John", customerInsurance.getName());

    }

}
