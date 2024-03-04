package br.com.insuranceapi.service;

import br.com.insuranceapi.client.IBGEApiClient;
import br.com.insuranceapi.dto.LocationDTO;
import br.com.insuranceapi.dto.LocationDTOTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class LocationValidatorServiceTest {

    @InjectMocks LocationValidatorService locationValidatorService;

    @Mock
    private IBGEApiClient ibgeApiClientTete;

    @BeforeEach()
    void setUp(){

        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testIsValid() throws Exception {

        ReflectionTestUtils.setField(ibgeApiClientTete, "ibgeUrl", "test.com");
        when(ibgeApiClientTete.getStates()).thenReturn(Arrays.asList(LocationDTO.builder().abbreviation("SP").build()));

        locationValidatorService.isValidLocation("SP");
    }

    @Test
    public void testIsValidLocationInvalid() throws Exception {

        when(ibgeApiClientTete.getStates()).thenReturn(Arrays.asList(LocationDTO.builder().abbreviation("SP").build()));
        assertThrows(Exception.class, () -> locationValidatorService.isValidLocation("RJ"));
    }
}
