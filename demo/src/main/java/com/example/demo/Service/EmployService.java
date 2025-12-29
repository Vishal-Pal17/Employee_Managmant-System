package com.example.demo.Service;

import com.example.demo.Dto.EmployeeDto;
import com.example.demo.Repository.EmployRepository;
import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployService {

    @Autowired
    private EmployRepository employRepository;

    public Employee Create(EmployeeDto dto){
        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setSalary(dto.getSalary());

        return employRepository.save(employee);
    }

    public Page<Employee> getAll(int page, int size , String sortBy){
        Pageable pageable = PageRequest.of(page , size, Sort.by(sortBy));
        return employRepository.findAll(pageable);
    }




    public Employee getById(Long id){
        return employRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee not found"));
    }

    public Employee update(Long id , EmployeeDto dto){
        Employee employee = getById(id);
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setSalary(dto.getSalary());
        return employRepository.save(employee);
    }

    public void delete(Long id){
        Employee employee = getById(id);
        employRepository.deleteById(id);
    }
}
