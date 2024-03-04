package br.com.insuranceapi.handler;

import br.com.insuranceapi.exception.BusinessException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CustomExceptionHandlerTest {

    @Mock
    private BusinessException businessException;

    @InjectMocks
    private CustomExceptionHandler customExceptionHandler;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testHandleEntityException() {
        String errorMessage = "State Invalid";
        when(businessException.getMessage()).thenReturn(errorMessage);

        ResponseEntity<String> responseEntity = customExceptionHandler.handleEntityException(businessException);

        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, responseEntity.getStatusCode());
        assertEquals(errorMessage, responseEntity.getBody());
    }
}
