package com.jupiter.oppsservice.repository;

import com.jupiter.oppsservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
