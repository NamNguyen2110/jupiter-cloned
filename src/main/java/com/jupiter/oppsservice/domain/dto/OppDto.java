package com.jupiter.oppsservice.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.jupiter.oppsservice.domain.enums.ActivityType;
import com.jupiter.oppsservice.domain.enums.OppStatus;
import com.jupiter.oppsservice.domain.enums.ProjectType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OppDto {
    private String id;
    private String projectCode;
    private String customerName;
    private String duPic;
    private ActivityType activityType;
    private ProjectType projectType;
    private OppStatus status;

    private List<OppApplicationDto> oppApplicationDtoList;
    private List<OppRequirementDto> oppRequirementDtoList;
    private List<OppSaleDto> oppSaleDtoList;
}