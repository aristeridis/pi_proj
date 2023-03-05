package com.pi_proj.pi_proj.repository;

import com.pi_proj.pi_proj.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    void deleteById(Long id);
}
