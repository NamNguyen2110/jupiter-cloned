package com.jupiter.oppsservice.service.impl;

import com.jupiter.oppsservice.domain.converter.OppApplicationMapper;
import com.jupiter.oppsservice.domain.dto.OppApplicationDto;
import com.jupiter.oppsservice.repository.OppApplicationRepository;
import com.jupiter.oppsservice.service.OppApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OppApplicationServiceImpl implements OppApplicationService {
    private final OppApplicationRepository oppAppRepository;
    private final OppApplicationMapper oppAppMapper;

    @Override
    public List<OppApplicationDto> get() {
        return oppAppRepository.findAll().stream().map(oppAppMapper::toDto).collect(Collectors.toList());
    }
}
