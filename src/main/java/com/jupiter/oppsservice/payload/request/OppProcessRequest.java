package com.jupiter.oppsservice.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OppProcessRequest {
    private String oppId;
    private String oppPositionId;
    @JsonProperty("processType")
    private String processType;

}
