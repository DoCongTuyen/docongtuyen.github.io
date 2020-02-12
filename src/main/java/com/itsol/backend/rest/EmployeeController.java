package com.itsol.backend.rest;


import com.itsol.backend.dto.AuthDto;
import com.itsol.backend.dto.EmployeeDto;
import com.itsol.backend.service.Impl.EmployeeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EmployeeServiceImpl employeeService;

    //Edit Employee
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateUser(@RequestBody EmployeeDto employeeDto, @PathVariable("id") long id){
        employeeDto.setId(id);
        logger.trace("REST to request update product: {}", employeeDto);
        try{
            employeeService.update(employeeDto);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //Delete Employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id){
        logger.trace("REST to request delete employee: {}", id);
        try{
            employeeService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get")
    ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        logger.trace("REST to request get all issue.");
        return new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") long id){
        logger.trace("REST to request get employee: {}", id);
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        if(employeeDto==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(employeeDto, HttpStatus.OK);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<EmployeeDto> login(@RequestBody AuthDto authDto){
        EmployeeDto employeeDto = employeeService.findByUsernameAndPassword(authDto);
        return new ResponseEntity<>(employeeDto,HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody EmployeeDto employeeDto){
        logger.trace("REST to request create issue: {}", employeeDto);

        try {
            employeeService.create(employeeDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception ex){
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

