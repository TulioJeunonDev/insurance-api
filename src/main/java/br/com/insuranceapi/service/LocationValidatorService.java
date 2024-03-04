package br.com.insuranceapi.service;

import br.com.insuranceapi.client.IBGEApiClient;
import br.com.insuranceapi.dto.LocationDTO;
import br.com.insuranceapi.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class LocationValidatorService {

    @Autowired
    private IBGEApiClient ibgeApiClient;

    public void isValidLocation(String location) throws RuntimeException {

        List<LocationDTO> states = ibgeApiClient.getStates();
        log.info("Method isValidLocation:: found {} states", states.size());

        boolean isValid = states.stream()
                .map(LocationDTO::getAbbreviation)
                .anyMatch(state -> state.equalsIgnoreCase(location));

        if(!isValid) throw new BusinessException("State Invalid");
    }
}
