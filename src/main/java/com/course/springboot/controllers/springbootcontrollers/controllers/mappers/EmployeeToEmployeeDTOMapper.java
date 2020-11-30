package com.course.springboot.controllers.springbootcontrollers.controllers.mappers;

import com.course.springboot.controllers.springbootcontrollers.controllers.dto.EmployeeDTO;
import com.course.springboot.controllers.springbootcontrollers.vo.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeToEmployeeDTOMapper {

    EmployeeToEmployeeDTOMapper INSTANCE = Mappers.getMapper(EmployeeToEmployeeDTOMapper.class);

    EmployeeDTO employeeToEmployeeDTO(Employee employee);

    Employee employeeDTOToEmployee(EmployeeDTO employee);
}
