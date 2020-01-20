package com.itsol.projectservice.rest;

import com.itsol.projectservice.dto.DepartmentDto;
import com.itsol.projectservice.service.Impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentService;

    @GetMapping("/getAll")
    ResponseEntity<List<DepartmentDto>> getAll(){
        return new ResponseEntity<>(departmentService.getAllDepartment(), HttpStatus.OK);
    }

}
