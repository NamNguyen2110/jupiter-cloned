package com.jupiter.oppsservice.controller;

import com.jupiter.common.annotation.AuthorizedFor;
import com.jupiter.common.base.ApiResponse;
import com.jupiter.common.constants.Role;
import com.jupiter.common.security.SecurityContext;
import com.jupiter.common.service.FileService;
import com.jupiter.common.service.MessageService;
import com.jupiter.common.service.S3StorageService;
import com.jupiter.common.utils.DataUtils;
import com.jupiter.common.utils.excel.EXPORT_TEMPLATE_TYPE;
import com.jupiter.common.utils.excel.ExportConfig;
import com.jupiter.oppsservice.entity.User;
import com.jupiter.oppsservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.Predicate;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/api/opps")
@RequiredArgsConstructor
public class TestResource {

    private final UserRepository repository;

    private final MessageService messageService;

    private final SecurityContext securityContext;

    private final FileService fileService;

    private final S3StorageService s3StorageService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<User>>> getAll(@RequestParam("id") Long id, @RequestParam("name") String name) {
        return ResponseEntity.ok(ApiResponse.<List<User>>builder()
                .errorCode(DataUtils.safeToString(HttpStatus.OK.value()))
                .messages(Arrays.asList(messageService.getMessage("error.code.success")))
                .data(repository.findAll())
                .build());
    }

    @AuthorizedFor(roles = Role.ADMIN)
    @GetMapping("/{id}")
    public ResponseEntity<User> getOne(@PathVariable("id") Long id) {
        return ResponseEntity.ok(repository.findById(id).orElseThrow());
    }

    @GetMapping("/header")
    public ResponseEntity<List<User>> getAllByHeader(@RequestHeader String header, @RequestBody Role role) {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/export/msexcel")
    public ResponseEntity<byte[]> exportExcel(@RequestParam EXPORT_TEMPLATE_TYPE type) {
        String fileName = "report.xlsx";
        byte[] bytes = fileService.export(type, ExportConfig.demo, new ArrayList<>());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .contentLength(bytes == null ? 0 : bytes.length)
                .body(bytes);
    }


    @PostMapping("/files")
    public ResponseEntity<List<String>> upload(@RequestPart MultipartFile file) {
        return ResponseEntity.ok()
                .body(s3StorageService.uploadFile(List.of(file)));
    }


}
