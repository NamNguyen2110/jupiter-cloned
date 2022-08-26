package com.jupiter.oppsservice.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.jupiter.oppsservice.domain.entity.OpportunityRequirement;
import com.jupiter.oppsservice.domain.enums.ActivityType;
import com.jupiter.oppsservice.domain.enums.OppStatus;
import com.jupiter.oppsservice.domain.enums.ProjectType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OppEmpSuggestionDto {
    private String id;
    private String employeeId;
    private OppRequirementDto oppRequirementDto;
}