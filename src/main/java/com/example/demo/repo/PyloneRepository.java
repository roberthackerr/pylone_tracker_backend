package com.example.demo.repo;

import com.example.demo.model.Pylone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PyloneRepository extends JpaRepository<Pylone, Long> {
}
