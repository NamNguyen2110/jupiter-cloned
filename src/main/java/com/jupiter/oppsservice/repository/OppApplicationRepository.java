package com.jupiter.oppsservice.repository;

import com.jupiter.oppsservice.domain.entity.OppApplication;
import com.jupiter.oppsservice.payload.request.OppProcessRequest;
import com.jupiter.oppsservice.payload.response.OppProcessResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OppApplicationRepository extends JpaRepository<OppApplication,String> {

}
