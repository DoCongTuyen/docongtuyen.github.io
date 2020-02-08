package com.itsol.backend.rest;

import com.itsol.backend.dto.ProjectDto;
import com.itsol.backend.service.Impl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectServiceImpl projectService;

    @GetMapping("/getAll")
    ResponseEntity<List<ProjectDto>> getAll(){
        return  new ResponseEntity<>(projectService.getAllProject(), HttpStatus.OK);
    }
}
