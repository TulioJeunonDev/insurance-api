package br.com.insuranceapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationDTO {

    @JsonProperty(value = "sigla")
    private String abbreviation;
}
