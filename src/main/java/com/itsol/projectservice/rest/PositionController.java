package com.itsol.projectservice.rest;


import com.itsol.projectservice.dto.PositionDto;
import com.itsol.projectservice.service.Impl.PositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/position")
public class PositionController {
    @Autowired
    private PositionServiceImpl positionService;

    @GetMapping("/getAll")
    ResponseEntity<List<PositionDto>> getAll(){
        return new ResponseEntity<>(positionService.getAllPosition(),HttpStatus.OK);
    }


}
