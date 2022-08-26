package com.jupiter.oppsservice.domain.dto.response;

import com.jupiter.oppsservice.domain.dto.request.OppRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OppResponse extends OppRequest {
    private String id;
}
