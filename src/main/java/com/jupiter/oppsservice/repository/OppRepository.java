package com.jupiter.oppsservice.repository;

import com.jupiter.oppsservice.domain.entity.Opp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface OppRepository extends JpaRepository<Opp, String> {

}
