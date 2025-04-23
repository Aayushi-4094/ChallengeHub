package com.embark.ChallengApp.dao;

import com.embark.ChallengApp.Challenge;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
    Optional<Challenge> findByMonthIgnoreCase(String month);
}

