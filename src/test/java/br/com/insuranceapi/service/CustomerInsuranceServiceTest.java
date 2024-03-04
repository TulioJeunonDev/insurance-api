package br.com.insuranceapi.service;

import br.com.insuranceapi.client.IBGEApiClient;
import br.com.insuranceapi.dto.CustomerDTO;
import br.com.insuranceapi.dto.CustomerInsuranceDTO;
import br.com.insuranceapi.dto.LocationDTO;
import br.com.insuranceapi.dto.LocationDTOTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CustomerInsuranceServiceTest {

    @InjectMocks
    CustomerInsuranceService customerInsuranceService;

    @Mock
    private IBGEApiClient ibgeApiClientTete;

    @Mock LocationValidatorService locationValidatorService;

    @BeforeEach()
    void setUp(){

        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByCustomerLowerPriceOnlyBasic() throws Exception{

        ReflectionTestUtils.setField(ibgeApiClientTete, "ibgeUrl", "test.com");
        when(ibgeApiClientTete.getStates()).thenReturn(Arrays.asList(LocationDTO.builder().abbreviation("SP").build()));
        CustomerInsuranceDTO customerInsurance = customerInsuranceService.findInsuranceByCustomer(loadCustomer("SP", 35, 70000.0));

        assertEquals(1,customerInsurance.getInsurances().size());
        assertEquals("Basico",customerInsurance.getInsurances().get(0).getType());

    }

    @Test
    void testFindByCustomerLowerPrice() throws Exception{

        ReflectionTestUtils.setField(ibgeApiClientTete, "ibgeUrl", "test.com");
        when(ibgeApiClientTete.getStates()).thenReturn(Arrays.asList(LocationDTO.builder().abbreviation("SP").build()));

        CustomerInsuranceDTO customerInsurance = customerInsuranceService.findInsuranceByCustomer(loadCustomer("SP", 20, 70000.0));

        assertEquals(2,customerInsurance.getInsurances().size());
        assertEquals("Basico",customerInsurance.getInsurances().get(0).getType());
        assertEquals("Parcial",customerInsurance.getInsurances().get(1).getType());

    }

    @Test
    void testFindByCustomerMediumPrice() throws Exception{

        ReflectionTestUtils.setField(ibgeApiClientTete, "ibgeUrl", "test.com");
        when(ibgeApiClientTete.getStates()).thenReturn(Arrays.asList(LocationDTO.builder().abbreviation("SP").build()));
        CustomerInsuranceDTO customerInsurance = customerInsuranceService.findInsuranceByCustomer(loadCustomer("SP", 20, 80000.0));

        assertEquals(2,customerInsurance.getInsurances().size());
        assertEquals("Basico",customerInsurance.getInsurances().get(0).getType());
        assertEquals("Parcial",customerInsurance.getInsurances().get(1).getType());

    }

    @Test
    void testFindByCustomerMediumPriceOnlyBasic() throws Exception{

        ReflectionTestUtils.setField(ibgeApiClientTete, "ibgeUrl", "test.com");
        when(ibgeApiClientTete.getStates()).thenReturn(Arrays.asList(LocationDTO.builder().abbreviation("SP").build()));
        CustomerInsuranceDTO customerInsurance = customerInsuranceService.findInsuranceByCustomer(loadCustomer("MG", 20, 80000.0));

        assertEquals(1,customerInsurance.getInsurances().size());
        assertEquals("Basico",customerInsurance.getInsurances().get(0).getType());

    }

    @Test
    void testFindByCustomerHighPrice() throws Exception{

        ReflectionTestUtils.setField(ibgeApiClientTete, "ibgeUrl", "test.com");
        when(ibgeApiClientTete.getStates()).thenReturn(Arrays.asList(LocationDTO.builder().abbreviation("SP").build()));
        CustomerInsuranceDTO customerInsurance = customerInsuranceService.findInsuranceByCustomer(loadCustomer("SP", 25, 100000.0));

        assertEquals(3,customerInsurance.getInsurances().size());
        assertEquals("Basico",customerInsurance.getInsurances().get(0).getType());
        assertEquals("Parcial",customerInsurance.getInsurances().get(1).getType());
        assertEquals("Total",customerInsurance.getInsurances().get(2).getType());

    }

    @Test
    void testFindByCustomerHighPriceOnlyBasicAndHigh() throws Exception{

        ReflectionTestUtils.setField(ibgeApiClientTete, "ibgeUrl", "test.com");
        when(ibgeApiClientTete.getStates()).thenReturn(Arrays.asList(LocationDTO.builder().abbreviation("SP").build()));
        CustomerInsuranceDTO customerInsurance = customerInsuranceService.findInsuranceByCustomer(loadCustomer("SP", 34, 100000.0));

        assertEquals(2,customerInsurance.getInsurances().size());
        assertEquals("Basico",customerInsurance.getInsurances().get(0).getType());
        assertEquals("Total",customerInsurance.getInsurances().get(1).getType());

    }

    private CustomerDTO loadCustomer(String location, Integer age, Double price){
        return CustomerDTO.builder().age(age).name("test").cpf("439.102.123-99").location(location).vehiclePrice(price).build();
    }
}
