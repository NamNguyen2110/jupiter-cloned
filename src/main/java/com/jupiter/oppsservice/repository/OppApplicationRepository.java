package com.jupiter.oppsservice.repository;

import com.jupiter.oppsservice.domain.entity.Opportunity;
import com.jupiter.oppsservice.domain.entity.OpportunityApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OppApplicationRepository extends JpaRepository<OpportunityApplication,String> {
}
