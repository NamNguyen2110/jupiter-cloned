package com.jupiter.oppsservice.service.impl;

import com.jupiter.common.security.SecurityContext;
import com.jupiter.common.service.MessageService;
import com.jupiter.oppsservice.domain.dto.request.OppRequest;
import com.jupiter.oppsservice.domain.dto.response.OppResponse;
import com.jupiter.oppsservice.domain.entity.Opp;
import com.jupiter.oppsservice.domain.entity.OppRequirement;
import com.jupiter.oppsservice.domain.mapper.OppMapper;
import com.jupiter.oppsservice.domain.mapper.OppRequirementMapper;
import com.jupiter.oppsservice.repository.OppRepository;
import com.jupiter.oppsservice.repository.OppRequirementRepository;
import com.jupiter.oppsservice.service.OppService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OppServiceImpl implements OppService {

    private final OppRepository oppRepo;

    private final OppRequirementRepository oppRequirementRepo;

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

        List<OppRequirement> oppRequirements = getOppRequirements(request, opp);
        oppRequirementRepo.saveAll(oppRequirements);

    }

    private List<OppRequirement> getOppRequirements(OppRequest request, Opp opp) {
        List<OppRequirement> oppRequirements = oppRequirementMapper.toEntityList(request.getOppRequirements());
        for (OppRequirement oppRequirement : oppRequirements) {
            oppRequirement.setOpp(opp);
        }
        return oppRequirements;
    }

    private void validate(OppRequest request) {
    }
}
