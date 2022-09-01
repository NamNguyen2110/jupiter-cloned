package com.jupiter.oppsservice.repository;

import com.jupiter.oppsservice.domain.dto.request.OppProcessRequest;
import com.jupiter.oppsservice.domain.dto.response.OppProcessResponse;

import java.util.List;

public interface OppProcessRepository {
    List<OppProcessResponse> getOppProcessResult(OppProcessRequest oppProcessRequest);
}
