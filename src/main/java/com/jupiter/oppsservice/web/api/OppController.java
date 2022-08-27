package com.jupiter.oppsservice.web.api;

import com.jupiter.common.base.ApiResponse;
import com.jupiter.common.security.SecurityContext;
import com.jupiter.common.service.MessageService;
import com.jupiter.common.service.S3StorageService;
import com.jupiter.common.utils.DataUtils;
import com.jupiter.oppsservice.domain.dto.request.OppRequest;
import com.jupiter.oppsservice.domain.dto.response.OppResponse;
import com.jupiter.oppsservice.service.OppService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/opps")
@RequiredArgsConstructor
public class OppController {

    private final SecurityContext securityContext;

    private final OppService oppService;

    private final MessageService messageService;

    private final S3StorageService s3StorageService;

    @GetMapping()
    public ResponseEntity<ApiResponse<Page<OppResponse>>> search(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.<Page<OppResponse>>builder()
                .errorCode(DataUtils.safeToString(HttpStatus.OK.value()))
                .messages(Arrays.asList(messageService.getMessage("error.code.success")))
                .data(oppService.search(pageable))
                .timestamp(LocalDateTime.now())
                .build());
    }

    @PostMapping()
    public ResponseEntity<ApiResponse<Object>> create(@RequestBody @Valid OppRequest request) {
        oppService.create(request);
        return ResponseEntity.ok(ApiResponse.builder()
                .errorCode(DataUtils.safeToString(HttpStatus.OK.value()))
                .messages(Arrays.asList(messageService.getMessage("error.code.success")))
                .data(null)
                .timestamp(LocalDateTime.now())
                .build());
    }

    @PostMapping("/uploadFile")
    public ResponseEntity<ApiResponse<Object>> uploadFile(@RequestPart(value = "files") List<MultipartFile> files) {
        return ResponseEntity.ok(ApiResponse.builder()
                .errorCode(DataUtils.safeToString(HttpStatus.OK.value()))
                .messages(Arrays.asList(messageService.getMessage("error.code.success")))
                .data(s3StorageService.uploadFile(files))
                .timestamp(LocalDateTime.now())
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<OppResponse>> getOppById(@PathVariable String id) {
        return ResponseEntity.ok(new ApiResponse<>(
                DataUtils.safeToString(HttpStatus.OK.value()),
                Collections.singletonList(messageService.getMessage("error.code.success")),
                oppService.getOppById(id),
                LocalDateTime.now()));
    }

}
