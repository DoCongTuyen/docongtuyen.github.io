package com.itsol.backend.rest;

import com.itsol.backend.dto.StatusDto;
import com.itsol.backend.service.Impl.StatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    @Autowired
    private StatusServiceImpl statusService;

    @RequestMapping("/getAll")
    ResponseEntity<List<StatusDto>> getAll(){
        return new ResponseEntity<>(statusService.getAllStatus(), HttpStatus.OK);
    }
}
