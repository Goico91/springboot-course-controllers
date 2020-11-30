package com.course.springboot.controllers.springbootcontrollers.controllers.mappers;

import com.course.springboot.controllers.springbootcontrollers.controllers.dto.ListEmployeesDTO;
import com.course.springboot.controllers.springbootcontrollers.vo.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeToListEmployeesDTOMapper {

    EmployeeToListEmployeesDTOMapper INSTANCE = Mappers.getMapper(EmployeeToListEmployeesDTOMapper.class);

    List<ListEmployeesDTO> employeeToListEmployeesDTO(List<Employee> employee);
}
