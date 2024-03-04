package br.com.insuranceapi.client;

import br.com.insuranceapi.dto.LocationDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class IBGEApiClient {

    @Value("${app.client.ibgeUrl}")
    private String ibgeUrl;

    public List<LocationDTO> getStates() throws RuntimeException {

        ResponseEntity<List<LocationDTO>> responseEntity = new RestTemplate().exchange(
                ibgeUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );

        if(!responseEntity.getStatusCode().is2xxSuccessful())
            throw new RuntimeException("Integration with IBGE failed");

        return responseEntity.getBody();
    }
}
