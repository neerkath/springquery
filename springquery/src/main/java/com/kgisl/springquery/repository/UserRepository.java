package com.kgisl.springquery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.springquery.model.Employee;
@Repository
public interface UserRepository extends JpaRepository<Employee,Integer> {
    
}
