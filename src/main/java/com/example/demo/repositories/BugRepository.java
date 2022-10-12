package com.example.demo.repositories;

import com.example.demo.models.BugReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BugRepository extends JpaRepository<BugReport, Long> {
}
