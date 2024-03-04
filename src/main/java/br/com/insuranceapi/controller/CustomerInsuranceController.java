package br.com.insuranceapi.controller;

import br.com.insuranceapi.dto.CustomerDTO;
import br.com.insuranceapi.dto.CustomerInsuranceDTO;
import br.com.insuranceapi.service.CustomerInsuranceService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1/insurance")
@Tag(name = "insurances")
public class CustomerInsuranceController {

    @Autowired
    private CustomerInsuranceService customerInsuranceService;

    @PostMapping("/find")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", description = "Invalid Data"),
            @ApiResponse(responseCode = "422", description = "Invalid Location"),
            @ApiResponse(responseCode = "500", description = "Integration failed")
    })
    public ResponseEntity<CustomerInsuranceDTO> findInsurancesByCustomer(@RequestBody @Valid CustomerDTO customerDTO){
        return ResponseEntity.ok().body(customerInsuranceService.findInsuranceByCustomer(customerDTO));
    }
}
