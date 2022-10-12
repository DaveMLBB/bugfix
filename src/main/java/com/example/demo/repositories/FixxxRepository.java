package com.example.demo.repositories;

import com.example.demo.models.Fixxx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixxxRepository extends JpaRepository<Fixxx, Long> {
}
