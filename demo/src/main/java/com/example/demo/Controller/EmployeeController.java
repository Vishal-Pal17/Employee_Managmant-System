package com.example.demo.Controller;

import com.example.demo.Dto.EmployeeDto;
import com.example.demo.Service.EmployService;
import com.example.demo.model.Employee;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployService employService;

    @PostMapping
    public Employee create(@RequestBody @Valid EmployeeDto employeedto){
        return employService.Create(employeedto);
    }

    @GetMapping
    public Page<Employee> getAll(@RequestParam (defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int size ,
                                 @RequestParam(defaultValue = "id") String shortBy){
        return employService.getAll(page, size, shortBy);

    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable("id") Long id){
        return employService.getById(id);
    }

    @PutMapping("/{id}")

    public Employee update(@PathVariable Long id , @RequestBody @Valid EmployeeDto dto){
        return employService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        employService.delete(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }

}
