package com.example.EmployeePayrollApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService service;

    @GetMapping("/")
    public List<EmployeePayrollModel> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public EmployeePayrollModel getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public EmployeePayrollModel create(@RequestBody EmployeePayrollModel emp) {
        return service.create(emp);
    }

    @PutMapping("/update")
    public EmployeePayrollModel update(@RequestBody EmployeePayrollModel emp) {
        return service.update(emp);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "Deleted Successfully";
    }
}
