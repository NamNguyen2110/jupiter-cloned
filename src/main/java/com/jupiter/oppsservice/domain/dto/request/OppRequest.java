package com.jupiter.oppsservice.domain.dto.request;

import com.jupiter.oppsservice.domain.enums.ActivityType;
import com.jupiter.oppsservice.domain.enums.OppStatus;
import com.jupiter.oppsservice.domain.enums.ProjectType;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OppRequest implements Serializable {

    @ApiModelProperty(example = "default")
    private String projectCode;
    @ApiModelProperty(example = "default")
    private String customerName;
    @ApiModelProperty(example = "default")
    private String duPic;

    private ActivityType activityType;

    private ProjectType projectType;

    private OppStatus status;

//
//    private List<OppApplicationDto> oppApplications;
//
    private List<OppRequirementRequest> oppRequirements;
//
//    private List<OppSaleDto> oppSales;
}
