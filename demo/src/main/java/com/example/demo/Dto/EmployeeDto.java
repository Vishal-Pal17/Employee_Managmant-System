package com.example.demo.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmployeeDto {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email formate")
    private String email;


    private double salary;
}
