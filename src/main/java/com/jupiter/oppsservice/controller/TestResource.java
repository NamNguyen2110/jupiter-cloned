package com.jupiter.oppsservice.controller;

import com.jupiter.common.annotation.AuthorizedFor;
import com.jupiter.common.constants.Role;

import com.jupiter.common.exception.BusinessException;
import com.jupiter.common.service.MessageService;
import com.jupiter.oppsservice.entity.User;
import com.jupiter.oppsservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/opps")
public class TestResource {

    @Autowired
    private UserRepository repository;
    @Autowired
    private MessageService messageService;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @AuthorizedFor(roles = Role.ADMIN)
    @GetMapping("/{id}")
    public ResponseEntity<User> getOne(@PathVariable("id") Long id) {
        return ResponseEntity.ok(repository.findById(id).orElseThrow());
    }

}
