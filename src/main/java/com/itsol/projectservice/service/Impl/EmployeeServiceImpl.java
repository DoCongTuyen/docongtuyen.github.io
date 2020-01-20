package com.itsol.projectservice.service.Impl;

import com.itsol.projectservice.domain.Employee;
import com.itsol.projectservice.dto.EmployeeDto;
import com.itsol.projectservice.repository.EmployeeRepository;
import com.itsol.projectservice.service.EmployeeService;


import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<EmployeeDto> getAllEmployee() {
        logger.trace("Service to get all Employee");
        List<Employee> employeeList = employeeRepository.findAll();
        modelMapper = new ModelMapper();
        return employeeList.stream().map(emloyee ->
                modelMapper.map(emloyee, EmployeeDto.class)).collect(Collectors.toList());
    }
    @Override
    public void create(EmployeeDto employeeDto) {
        logger.trace("Service to create employee : ", employeeDto);
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        employeeRepository.save(employee);
        System.out.println(employee);
    }

//    @Override
//    public Employee getById(long id) {
//        return employeeRepository.findById(id).orElse(null);
//    }

    @Override
    public void save(EmployeeDto employeeDto) {
        logger.trace("Service to create {}", employeeDto);
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(long id) {
        employeeRepository.deleteById(id);

    }

    @Override
    public List<EmployeeDto> getEmployeeById() {
        return null;
    }

    @Override
    public void update(EmployeeDto employeeDto) {

    }

    @Override
    public boolean confirmEmployee(EmployeeDto employeeDto) {
        return true;
    }

}
