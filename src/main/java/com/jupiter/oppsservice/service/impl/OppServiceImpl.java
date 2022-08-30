package com.jupiter.oppsservice.service.impl;

import com.jupiter.common.exception.BusinessException;
import com.jupiter.common.security.SecurityContext;
import com.jupiter.common.service.MessageService;
import com.jupiter.oppsservice.domain.dto.request.OppRequest;
import com.jupiter.oppsservice.domain.dto.response.OppResponse;
import com.jupiter.oppsservice.domain.entity.Opp;
import com.jupiter.oppsservice.domain.entity.OppPosition;
import com.jupiter.oppsservice.domain.mapper.OppMapper;
import com.jupiter.oppsservice.domain.mapper.OppRequirementMapper;
import com.jupiter.oppsservice.repository.OppRepository;
import com.jupiter.oppsservice.repository.OppPositionRepository;
import com.jupiter.oppsservice.service.OppService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OppServiceImpl implements OppService {

    private final OppRepository oppRepo;

    private final OppPositionRepository oppRequirementRepo;

    private final MessageService messageService;

    private final OppMapper oppMapper;

    private final OppRequirementMapper oppRequirementMapper;

    private final SecurityContext securityContext;


    @Override
    public Page<OppResponse> search(Pageable pageable) {
        return oppRepo.findAll(pageable).map(oppMapper::toDto);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void create(OppRequest request) {
        validate(request);
        /*
        TODO:
         - save opp
         - save opp requirement
         - validate
         */

        Opp opp = oppMapper.toEntity(request);
        oppRepo.save(opp);

        List<OppPosition> oppPositions = getOppRequirements(request, opp);
        oppRequirementRepo.saveAll(oppPositions);

    }

    private List<OppPosition> getOppRequirements(OppRequest request, Opp opp) {
        List<OppPosition> oppPositions = oppRequirementMapper.toEntityList(request.getOppRequirements());
        for (OppPosition oppPosition : oppPositions) {
            oppPosition.setOpp(opp);
        }
        return oppPositions;
    }

    @Override
    public void updateStatus(String oppId, Opp opp) {
        Opp opp1 = oppRepo.findById(oppId).orElseThrow(
                () -> new BusinessException(messageService.getMessage("error.code.opp.notFound")));
        opp1.setStatus(opp.getStatus());
        oppRepo.save(opp1);
    }

    private void validate(OppRequest request) {
    }
}
