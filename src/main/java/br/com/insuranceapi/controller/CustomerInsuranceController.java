package br.com.insuranceapi.controller;

import br.com.insuranceapi.dto.CustomerDTO;
import br.com.insuranceapi.dto.CustomerInsuranceDTO;
import br.com.insuranceapi.service.CustomerInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1/insurance")
public class CustomerInsuranceController {

    @Autowired
    private CustomerInsuranceService customerInsuranceService;

    @PostMapping("/find")
    public ResponseEntity<CustomerInsuranceDTO> findInsurancesByCustomer(@RequestBody @Valid CustomerDTO customerDTO){
        return ResponseEntity.ok().body(customerInsuranceService.findInsuranceByCustomer(customerDTO));
    }
}
