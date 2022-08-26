package com.jupiter.oppsservice.web.api;

import com.jupiter.common.base.ApiResponse;
import com.jupiter.common.security.SecurityContext;
import com.jupiter.common.service.MessageService;
import com.jupiter.common.utils.DataUtils;
import com.jupiter.oppsservice.domain.dto.response.OppResponse;
import com.jupiter.oppsservice.service.OppService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/api/opps")
@RequiredArgsConstructor
public class OppController {

    private final SecurityContext securityContext;

    private final OppService oppService;

    private final MessageService messageService;

    @GetMapping()
    public ResponseEntity<ApiResponse<Page<OppResponse>>> search(Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.<Page<OppResponse>>builder()
                .errorCode(DataUtils.safeToString(HttpStatus.OK.value()))
                .messages(Arrays.asList(messageService.getMessage("error.code.success")))
                .data(oppService.search(pageable))
                .build());
    }
}
