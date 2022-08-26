package com.jupiter.oppsservice.service.impl;

import com.jupiter.oppsservice.domain.converter.OppMapper;
import com.jupiter.oppsservice.domain.dto.OppDto;
import com.jupiter.oppsservice.repository.OppRepository;
import com.jupiter.oppsservice.service.OppService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OppServiceImpl implements OppService {
    private final OppRepository oppRepository;
    private final OppMapper oppMapper;

    @Override
    public List<OppDto> get() {
        return oppRepository.findAll().stream().map(oppMapper::toDto).collect(Collectors.toList());
    }
}
