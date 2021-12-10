package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.EmployeeEntity;
import com.example.demo.model.LeaveEntity;
 
@Repository
public interface LeaveRepository
        extends JpaRepository<LeaveEntity, Long> {
 
}
