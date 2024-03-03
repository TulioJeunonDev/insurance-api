package br.com.insuranceapi.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerDTOTest {

    @Test
    void testConstructor(){

        CustomerDTO customer = new CustomerDTO("John", "445.323.121-11", 31, "MG", 85000.0);

        assertEquals("445.323.121-11", customer.getCpf());
        assertEquals("John", customer.getName());
        assertEquals(31, customer.getAge());
        assertEquals("MG", customer.getLocation());
        assertEquals(85000.0, customer.getVehiclePrice());

    }
}
