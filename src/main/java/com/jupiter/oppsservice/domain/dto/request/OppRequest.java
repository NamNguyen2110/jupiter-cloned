package com.jupiter.oppsservice.domain.dto.request;

import com.jupiter.oppsservice.domain.enums.ActivityType;
import com.jupiter.oppsservice.domain.enums.OppStatus;
import com.jupiter.oppsservice.domain.enums.ProjectType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OppRequest {

    private String projectCode;

    private String customerName;

    private String duPic;


    private ActivityType activityType;

    private ProjectType projectType;

    private OppStatus status;

//
//    private List<OppApplicationDto> oppApplications;
//
//    private List<OppRequirementDto> oppRequirements;
//
//    private List<OppSaleDto> oppSales;
}
