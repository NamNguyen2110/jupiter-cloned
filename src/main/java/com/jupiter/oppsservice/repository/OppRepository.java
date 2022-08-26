package com.jupiter.oppsservice.repository;

import com.jupiter.oppsservice.domain.entity.Opp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OppRepository extends JpaRepository<Opp, String> {
}
