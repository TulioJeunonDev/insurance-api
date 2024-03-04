package br.com.insuranceapi.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocationDTOTest {

    @Test
    void testConstructor(){

        LocationDTO location = new LocationDTO();
        location.setAbbreviation("SP");

        assertEquals("SP",location.getAbbreviation());

    }

}
