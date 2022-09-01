package com.jupiter.oppsservice.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OppProcessResponse {

    private String oppId;

    private String oppPositionId;

    private String processType;

    private String status;

    //amount of employee in an opp and requirement
    private int submittedAmount;

    //quantity of each status for each process
    private Integer quantityStatus;

}
