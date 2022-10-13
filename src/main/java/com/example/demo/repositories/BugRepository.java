package com.example.demo.repositories;

import com.example.demo.models.BugReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BugRepository extends JpaRepository<BugReport, Long> {

    @Override
    Optional<BugReport> findById(Long aLong);
}
