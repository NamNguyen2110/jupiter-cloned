package com.jupiter.oppsservice.domain.dto.response;

import com.jupiter.oppsservice.domain.dto.request.OppRequest;
import com.jupiter.oppsservice.domain.enums.OppStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OppResponse extends OppRequest {
    private OppStatus status;
}
