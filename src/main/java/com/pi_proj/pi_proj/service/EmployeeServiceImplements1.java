package com.pi_proj.pi_proj.service;

import com.pi_proj.pi_proj.model.Employee;
import com.pi_proj.pi_proj.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service//deploy and UI
public class EmployeeServiceImplements1 implements EmployeeService{
    @Autowired//generting ID
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee emp) {
        this.employeeRepository.save(emp);

    }

    @Override
    public Employee getEmployeeByID(Long id) {
        Optional<Employee> optional=employeeRepository.findById(id);
        Employee employee=null;
        if(optional.isPresent()){
            employee=optional.get();
        }else{
            throw new RuntimeException("O employee δεν βρέθηκε by id= "+id);
        }
        return employee;
    }

    @Override
    public void deleteEmployeeByID(Long id) {
        this.employeeRepository.deleteById(id);

    }

    @Override
    public Page<Employee> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
                : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        return this.employeeRepository.findAll(pageable);
    }
}
