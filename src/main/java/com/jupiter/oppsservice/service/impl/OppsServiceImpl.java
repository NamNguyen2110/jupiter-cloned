package com.jupiter.oppsservice.service.impl;

import com.jupiter.oppsservice.dto.OppsRequestDto;
import com.jupiter.oppsservice.dto.OppsResponseDto;
import com.jupiter.oppsservice.service.OppsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OppsServiceImpl implements OppsService {

    @Override
    public OppsResponseDto addGeneralInfoOpps(OppsRequestDto oppsRequestDto) {
        OppsResponseDto oppsResponseDto = new OppsResponseDto();
        oppsResponseDto.setId(1L);
        oppsResponseDto.setActivityType(oppsRequestDto.getActivityType());
        oppsResponseDto.setProjectType(oppsRequestDto.getProjectType());
        oppsResponseDto.setProjectCode(oppsRequestDto.getProjectCode());
        oppsResponseDto.setCustomerName(oppsRequestDto.getCustomerName());
        oppsResponseDto.setDuPic(oppsRequestDto.getDuPic());
        oppsResponseDto.setSalePicId(9L);
        oppsResponseDto.setOppsStatus(oppsRequestDto.getOppsStatus());
        return oppsResponseDto;
    }
}
