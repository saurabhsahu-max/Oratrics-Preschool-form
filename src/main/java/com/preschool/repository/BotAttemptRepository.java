package com.preschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.preschool.entity.BotAttempt;

public interface BotAttemptRepository extends JpaRepository<BotAttempt,Long> {
}