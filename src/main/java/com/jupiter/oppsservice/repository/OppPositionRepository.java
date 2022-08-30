package com.jupiter.oppsservice.repository;

import com.jupiter.oppsservice.domain.entity.OppPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OppPositionRepository extends JpaRepository<OppPosition, String> {
}
