package com.course.springboot.controllers.springbootcontrollers.controllers;

import com.course.springboot.controllers.springbootcontrollers.controllers.dto.EmployeeDTO;
import com.course.springboot.controllers.springbootcontrollers.controllers.dto.ListEmployeesDTO;
import com.course.springboot.controllers.springbootcontrollers.controllers.mappers.EmployeeToEmployeeDTOMapper;
import com.course.springboot.controllers.springbootcontrollers.controllers.mappers.EmployeeToListEmployeesDTOMapper;
import com.course.springboot.controllers.springbootcontrollers.vo.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ControllerImpl for Employees Services
 */
@RestController
public class EmployeesController implements EmployeesApi {

    private final List<Employee> employees = new ArrayList<>();

    public EmployeesController() {
        employees.add(new Employee(0, "Adams", "Usman", "12345678", 20, "intern", Arrays.asList("java", "spring", "spring boot", "angular")));
        employees.add(new Employee(1, "Baker", "Hills", "87654321", 22, "intern", Arrays.asList("angular", "react", "spring boot")));
        employees.add(new Employee(2, "Clark", "Irwin", "18273645", 26, "developer", Arrays.asList("java", "spring", "spring boot")));
        employees.add(new Employee(3, "Davis", "Jones", "54637181", 30, "developer", Arrays.asList("react", "ionic")));
        employees.add(new Employee(4, "Evans", "Klein", "19283745", 34, "senior developer", Arrays.asList("java", "spring", "spring boot")));
        employees.add(new Employee(5, "Frank", "Mason", "19827432", 38, "development project leader", Arrays.asList("java", "spring", "spring boot", "angular")));
    }

    @Override
    public ResponseEntity<List<ListEmployeesDTO>> getEmployees(String name, String knowledge) {
        return ResponseEntity.ok().body(EmployeeToListEmployeesDTOMapper.INSTANCE.employeeToListEmployeesDTO(employees));
    }

    @Override
    public ResponseEntity<EmployeeDTO> getEmployee(int id) {
        // Search for employee
        Employee employeeAux = employees.stream().filter(employee -> employee.getId() == id).findFirst().orElse(null);

        // Check if null
        if(employeeAux == null) {
            return ResponseEntity.notFound().build();
        }

        // Employee to EmployeeDTO
        EmployeeDTO employeeDTO = EmployeeToEmployeeDTOMapper.INSTANCE.employeeToEmployeeDTO(employeeAux);

        return ResponseEntity.ok().body(employeeDTO);
    }

    @Override
    public ResponseEntity<Void> createEmployee(EmployeeDTO employeeDTO) {
        // Check if exists
        Employee employeeAux = employees.stream().filter(employee -> employee.getId() == employeeDTO.getId()).findFirst().orElse(null);
        if(employeeAux != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // Map EmployeeDTO to Employee
        Employee employee = EmployeeToEmployeeDTOMapper.INSTANCE.employeeDTOToEmployee(employeeDTO);
        employees.add(employee);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
