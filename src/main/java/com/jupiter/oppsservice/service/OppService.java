package com.jupiter.oppsservice.service;

import com.jupiter.oppsservice.domain.dto.request.OppRequest;
import com.jupiter.oppsservice.domain.dto.response.OppResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OppService {

    Page<OppResponse> search(Pageable pageable);

    void create(OppRequest request);

    OppResponse getOppById(String id);
}
