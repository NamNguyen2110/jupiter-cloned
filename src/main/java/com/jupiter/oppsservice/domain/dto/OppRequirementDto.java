package com.jupiter.oppsservice.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.jupiter.oppsservice.domain.entity.Opportunity;
import com.jupiter.oppsservice.domain.enums.Level;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OppRequirementDto {
    private String id;
    private OppDto oppDto;
    private Integer quantity;
    private String position;
    private Level level;
    private String exp;
    private String skillStack;
    private String note;
}
