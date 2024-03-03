package br.com.insuranceapi.controller;

import br.com.insuranceapi.dto.CustomerDTO;
import br.com.insuranceapi.dto.CustomerInsuranceDTO;
import br.com.insuranceapi.service.CustomerInsuranceService;
import com.google.gson.Gson;
import jakarta.servlet.ServletContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class CustomerInsuranceControllerTest {
    @Configuration
    static class ControllerTestConfiguration{

        @Bean
        public CustomerInsuranceService customerInsuranceService(){
            return mock(CustomerInsuranceService.class);
        }

        @Bean
        public CustomerInsuranceController customerInsuranceController(){
            return new CustomerInsuranceController();
        }
    }

    @Autowired
    private CustomerInsuranceService customerInsuranceService;

    @Autowired
    private CustomerInsuranceController customerInsuranceController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp(){

        mockMvc = MockMvcBuilders.standaloneSetup(this.customerInsuranceController).build();
    }

    @Test
    public void testFindInsurance() throws Exception{

        when(customerInsuranceService.findInsuranceByCustomer(loadCustomer("SP", 30, 70000.0))).thenReturn(loadCustomerInsurance());

        String json = new Gson().toJson(loadCustomer("SP", 30, 70000.0));

        mockMvc.perform(
                MockMvcRequestBuilders.post("/v1/insurance/find")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    private CustomerInsuranceDTO loadCustomerInsurance(){
        return CustomerInsuranceDTO.builder().name("test").insurances(new ArrayList<>()).build();
    }

    private CustomerDTO loadCustomer(String location, Integer age, Double price){
        return CustomerDTO.builder().age(age).name("test").location(location).vehiclePrice(price).build();
    }
}
