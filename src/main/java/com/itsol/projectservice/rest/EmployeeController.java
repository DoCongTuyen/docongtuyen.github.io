package com.itsol.projectservice.rest;


import com.itsol.projectservice.dto.EmployeeDto;
import com.itsol.projectservice.service.Impl.EmployeeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/employee")
@CrossOrigin("*")
public class EmployeeController {

Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/getAll")
    ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        logger.trace("REST to request get all issue.");
        return new ResponseEntity<>(employeeService.getAllEmployee(),HttpStatus.OK);
        //tra ve doi tuong ResponseEntity chua du lieu tao ra va httpstatus
    }

    @PostMapping("/create")
    public ResponseEntity<Void> save(@RequestBody EmployeeDto employeeDto){
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

