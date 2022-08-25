package com.jupiter.oppsservice.controller;

import com.jupiter.common.base.ApiResponse;
import com.jupiter.common.security.SecurityContext;
import com.jupiter.common.service.MessageService;
import com.jupiter.oppsservice.dto.OppsRequestDto;
import com.jupiter.oppsservice.dto.OppsResponseDto;
import com.jupiter.oppsservice.service.OppsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collections;

@RestController
@RequestMapping("/api/opps")
@RequiredArgsConstructor
public class OppsController {
    private final SecurityContext securityContext;

    private final OppsService oppsService;

    private final MessageService messageService;

    @PostMapping()
    public ResponseEntity<ApiResponse<OppsResponseDto>> addGeneralInfoOpps(@RequestBody OppsRequestDto oppsRequestDto) {
        return ResponseEntity.ok(new ApiResponse<>(
                HttpStatus.OK.name(),
                Collections.singletonList(messageService.getMessage("error.code.success")),
                oppsService.addGeneralInfoOpps(oppsRequestDto),
                LocalDateTime.now()
        ));
    }
}
