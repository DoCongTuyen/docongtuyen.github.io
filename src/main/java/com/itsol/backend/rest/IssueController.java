package com.itsol.backend.rest;

import com.itsol.backend.dto.IssueDto;
import com.itsol.backend.service.Impl.IssueServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/issue")
@CrossOrigin("*")
public class IssueController {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private IssueServiceImpl issueService;


    @GetMapping("/get-all")
    ResponseEntity<List<IssueDto>> getAllIssue(){
        logger.trace("REST to request get all issue.");
        return new ResponseEntity<>(issueService.getAllIssue(), HttpStatus.OK);
        //tra ve doi tuong ResponseEntity chua du lieu tao ra va httpstatus
    }

    @PostMapping("/create")
    public ResponseEntity<Void> saveIssue(@RequestBody IssueDto issueDto){
        logger.trace("REST to request create issue: {}", issueDto);
        try {
            issueService.create(issueDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception ex){
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
