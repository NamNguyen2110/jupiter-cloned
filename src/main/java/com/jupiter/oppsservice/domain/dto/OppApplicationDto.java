package com.jupiter.oppsservice.domain.dto;
import com.jupiter.oppsservice.domain.enums.OppAppStatus;
import com.jupiter.oppsservice.domain.enums.ProcessType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OppApplicationDto {
    private String id;
    private OppRequirementDto oppRequirementDto;
    private String employeeId;
    private OppDto oppDto;
    private OppAppStatus status;
    private ProcessType processType;
}
