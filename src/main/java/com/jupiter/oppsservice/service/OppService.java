package com.jupiter.oppsservice.service;

import com.jupiter.oppsservice.payload.request.OppProcessRequest;
import com.jupiter.oppsservice.payload.request.OppRequest;
import com.jupiter.oppsservice.payload.response.OppProcessResponse;
import com.jupiter.oppsservice.payload.response.OppResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OppService {

    Page<OppResponse> search(Pageable pageable);

    void create(OppRequest request);

    OppResponse getOppById(String id);
    List<OppProcessResponse> getOppProcessResult (OppProcessRequest oppProcessRequest);}
