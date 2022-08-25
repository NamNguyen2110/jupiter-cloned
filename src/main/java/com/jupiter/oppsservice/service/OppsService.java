package com.jupiter.oppsservice.service;

import com.jupiter.oppsservice.dto.OppsRequestDto;
import com.jupiter.oppsservice.dto.OppsResponseDto;

public interface OppsService {
    OppsResponseDto addGeneralInfoOpps(OppsRequestDto oppsRequestDto);
}
