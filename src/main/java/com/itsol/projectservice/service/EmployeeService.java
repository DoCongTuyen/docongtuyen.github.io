package com.itsol.projectservice.service;

import com.itsol.projectservice.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> getAllEmployee();

    void create(EmployeeDto employeeDto);

    void save(EmployeeDto employeeDto);

    void deleteById(long id);

    List<EmployeeDto> getEmployeeById();

    void update(EmployeeDto employeeDto);

    boolean confirmEmployee(EmployeeDto employeeDto);



}
