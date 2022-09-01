package com.jupiter.oppsservice.service;

import com.jupiter.oppsservice.domain.dto.request.OppProcessRequest;
import com.jupiter.oppsservice.domain.dto.request.OppRequest;
import com.jupiter.oppsservice.domain.dto.response.OppProcessResponse;
import com.jupiter.oppsservice.domain.dto.response.OppResponse;
import com.jupiter.oppsservice.domain.entity.Opp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OppService {

    Page<OppResponse> search(Pageable pageable);

    void create(OppRequest request);

    void update(OppRequest request);

    void updateStatus(String id, Opp opp);

    List<OppProcessResponse> getOppProcessResult(OppProcessRequest oppProcessRequest);
}
