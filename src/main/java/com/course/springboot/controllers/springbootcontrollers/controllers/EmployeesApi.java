package com.course.springboot.controllers.springbootcontrollers.controllers;

import com.course.springboot.controllers.springbootcontrollers.controllers.dto.EmployeeDTO;
import com.course.springboot.controllers.springbootcontrollers.controllers.dto.ListEmployeesDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * API for Employees Services
 */
@RequestMapping(value = "/employees")
public interface EmployeesApi {

    @GetMapping
    ResponseEntity<List<ListEmployeesDTO>> getEmployees(@RequestParam(required = false) String name, @RequestParam(required = false) String knowledge);

    @GetMapping("/{id}")
    ResponseEntity<EmployeeDTO> getEmployee(@PathVariable int id);

    @PostMapping
    ResponseEntity<Void> createEmployee(@RequestBody EmployeeDTO employeeDTO);
}
