package com.itsol.projectservice.rest;

import com.itsol.projectservice.dto.TeamDto;
import com.itsol.projectservice.service.Impl.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/team")
public class TeamController {

    @Autowired
    private TeamServiceImpl teamService;

    @GetMapping("/getAll")
    ResponseEntity<List<TeamDto>> getAll(){
        return new ResponseEntity<>(teamService.getAllTeam(), HttpStatus.OK);
    }
}
