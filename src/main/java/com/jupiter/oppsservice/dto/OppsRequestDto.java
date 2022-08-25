package com.jupiter.oppsservice.dto;

import com.jupiter.oppsservice.constant.ActivityType;
import com.jupiter.oppsservice.constant.ProjectType;
import com.jupiter.oppsservice.constant.OppsStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OppsRequestDto {
    private ActivityType activityType;
    private ProjectType projectType;
    private String projectCode;
    private String customerName;
    private String duPic;
    private OppsStatus oppsStatus;
}
