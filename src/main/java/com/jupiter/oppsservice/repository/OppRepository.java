package com.jupiter.oppsservice.repository;

import com.jupiter.oppsservice.domain.entity.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OppRepository extends JpaRepository<Opportunity,String> {
}
