package com.jupiter.oppsservice.controller;

import com.jupiter.oppsservice.service.OppService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/opps")
@RequiredArgsConstructor
public class OppController {

    @Autowired
    OppService oppService;

    @GetMapping("/public")
    public ResponseEntity<?> getAllPublic() {
        return ResponseEntity.ok(oppService.get());
    }
}
