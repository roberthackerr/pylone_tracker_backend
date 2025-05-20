package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Contract;
import com.example.demo.model.ContractStatus;
@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    
    List<Contract> findByUserId(Long userId);
    
    Optional<Contract> findByIdAndUserId(Long id, Long userId);
    
   
}