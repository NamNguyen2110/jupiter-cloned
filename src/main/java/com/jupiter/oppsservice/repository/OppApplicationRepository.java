package com.jupiter.oppsservice.repository;

import com.jupiter.oppsservice.domain.entity.OppApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OppApplicationRepository extends JpaRepository<OppApplication,String> {
}
