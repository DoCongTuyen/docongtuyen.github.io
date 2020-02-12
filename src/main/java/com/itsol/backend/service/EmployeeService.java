package com.itsol.backend.service;

import com.itsol.backend.dto.AuthDto;
import com.itsol.backend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService  {

    List<EmployeeDto> getAllEmployee();

    void create(EmployeeDto employeeDto);


    void deleteById(long id);


    EmployeeDto getEmployeeById(Long id);

    EmployeeDto update(EmployeeDto employeeDto);
    EmployeeDto findByUsernameAndPassword(AuthDto authDto);





}
