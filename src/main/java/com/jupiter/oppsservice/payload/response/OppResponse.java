package com.jupiter.oppsservice.payload.response;

import com.jupiter.oppsservice.payload.request.OppRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OppResponse extends OppRequest {
    private String id;
}
