package com.itsol.backend.service.Impl;

import com.itsol.backend.domain.Employee;
import com.itsol.backend.dto.AuthDto;
import com.itsol.backend.dto.EmployeeDto;
import com.itsol.backend.repository.EmployeeRepository;
import com.itsol.backend.service.EmployeeService;
import com.itsol.backend.utils.CopyUtil;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class EmployeeServiceImpl implements EmployeeService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder encoder;



    @Override
    public List<EmployeeDto> getAllEmployee() {
        logger.trace("Service to get all employee");
        List<Employee>employees = employeeRepository.findAll();
        return employees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public void create(EmployeeDto employeeDto) {
        logger.trace("Service to create employee : {}", employeeDto);
        employeeDto.setPassword(encoder.encode(employeeDto.getPassword()));
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        employeeRepository.save(employee);
        System.out.println(employee);
    }

    @Override
    public void deleteById(long id) {
        logger.trace("Service to delete product by employeeId= {}", id);
        employeeRepository.deleteById(id);

    }



    @Override
    public EmployeeDto getEmployeeById(Long id) {
        logger.trace("Service to get product by employeeId = {}", id);
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        return employeeOptional
                .map(position ->modelMapper.map(position, EmployeeDto.class))
                .orElse(null);
    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto) {

        Employee oldEmployee = employeeRepository.findById(employeeDto.getId()).get();
//        employeeDto.setPassword(encoder.encode(employeeDto.getPassword()));
        Employee employee = modelMapper.map(employeeDto,Employee.class);
        CopyUtil.copyOldToNewModel(oldEmployee,employee);
        employee.setPassword(encoder.encode(employee.getPassword()));
        employeeRepository.save(employee);
        return modelMapper.map(employee,EmployeeDto.class);
    }

    @Override
    public EmployeeDto findByUsernameAndPassword(AuthDto authDto) {
        Optional<Employee> employee= employeeRepository.findByUsernameAndPassword(authDto.getUsername(),authDto.getPassword());
        if (employee.get().getActivated() ==0 ) {
            return null;
        }
        return employee
                .map(position ->modelMapper.map(position, EmployeeDto.class))
                .orElse(null);
    }


}
