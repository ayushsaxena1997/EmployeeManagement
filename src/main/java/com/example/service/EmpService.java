package com.example.service;

import com.example.entity.Employee;
import com.example.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    private EmpRepo repo;

    public void addEmployee(Employee e){
        repo.save(e);
    }

    public List<Employee> getAllEmployees(){
        return repo.findAll();
    }

    public Employee getEmployeeById(int id){
        Optional<Employee> e = repo.findById(id);
        if(e.isPresent()) return e.get();
        return null;
    }

    public void deleteEmployee(int id){
        repo.deleteById(id);
    }
}
