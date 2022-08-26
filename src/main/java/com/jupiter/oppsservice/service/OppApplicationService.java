package com.jupiter.oppsservice.service;

import com.jupiter.oppsservice.domain.dto.OppApplicationDto;
import com.jupiter.oppsservice.domain.dto.OppDto;

import java.util.List;

public interface OppApplicationService {
    List<OppApplicationDto> get();
}
