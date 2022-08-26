package com.jupiter.oppsservice.repository;

import com.jupiter.oppsservice.domain.entity.OppRequirement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OppRequirementRepository extends JpaRepository<OppRequirement, String> {
}
