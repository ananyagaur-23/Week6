package com.example.EmployeePayrollApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository repository;

    public List<EmployeePayrollModel> getAll() {
        return repository.findAll();
    }

    public EmployeePayrollModel getById(int id) {
        return repository.findById(id).orElse(null);
    }

    public EmployeePayrollModel create(EmployeePayrollModel emp) {
        return repository.save(emp);
    }

    public EmployeePayrollModel update(EmployeePayrollModel emp) {
        return repository.save(emp);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
