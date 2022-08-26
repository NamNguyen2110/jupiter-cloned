package com.jupiter.oppsservice.web.api;

import com.jupiter.common.base.ApiResponse;
import com.jupiter.common.security.SecurityContext;
import com.jupiter.common.service.MessageService;
import com.jupiter.common.utils.DataUtils;
import com.jupiter.oppsservice.domain.dto.request.OppRequest;
import com.jupiter.oppsservice.domain.dto.response.OppResponse;
import com.jupiter.oppsservice.service.OppService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
                .timestamp(LocalDateTime.now())
                .build());
    }

    @PostMapping()
    public ResponseEntity<ApiResponse<Object>> create(@RequestBody OppRequest request) {
        oppService.create(request);
        return ResponseEntity.ok(ApiResponse.builder()
                .errorCode(DataUtils.safeToString(HttpStatus.OK.value()))
                .messages(Arrays.asList(messageService.getMessage("error.code.success")))
                .data(null)
                .timestamp(LocalDateTime.now())
                .build());
    }
}
