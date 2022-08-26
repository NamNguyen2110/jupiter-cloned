package com.jupiter.oppsservice.service.impl;

import com.jupiter.common.service.MessageService;
import com.jupiter.oppsservice.domain.dto.response.OppResponse;
import com.jupiter.oppsservice.repository.OppRepository;
import com.jupiter.oppsservice.service.OppService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OppServiceImpl implements OppService {

    private final OppRepository oppRepo;

    private final MessageService messageService;


    @Override
    public Page<OppResponse> search(Pageable pageable) {
        return null;
    }
}
