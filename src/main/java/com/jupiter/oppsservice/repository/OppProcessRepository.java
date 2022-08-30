package com.jupiter.oppsservice.repository;

import com.jupiter.oppsservice.payload.request.OppProcessRequest;
import com.jupiter.oppsservice.payload.response.OppProcessResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OppProcessRepository{
    List<OppProcessResponse> getOppProcessResult(OppProcessRequest oppProcessRequest);
}
