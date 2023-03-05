package com.pi_proj.pi_proj.service;

import com.pi_proj.pi_proj.model.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee emp);
    Employee getEmployeeByID(Long id);
    void deleteEmployeeByID(Long id);
    Page<Employee> findPaginated(int pageNum,int pageSize,String sortField,String strongDirection);
}
