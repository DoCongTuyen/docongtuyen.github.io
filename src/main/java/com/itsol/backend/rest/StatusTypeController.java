package com.itsol.backend.rest;

import com.itsol.backend.dto.StatusTypeDto;
import com.itsol.backend.service.Impl.StatusTypeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statustype")
public class StatusTypeController {

    @Autowired
    private StatusTypeImpl statusType;

    @GetMapping("/getAll")
    public ResponseEntity<List<StatusTypeDto>> getAll(){
        return  new ResponseEntity<>(statusType.getAllStatusType(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> saveStatusType(@RequestBody StatusTypeDto statusTypeDto){
        try {
            statusType.create(statusTypeDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find-one/{statusTypeID}")
    public ResponseEntity<StatusTypeDto> getStatusType(@PathVariable Long statusTypeID){
        StatusTypeDto statusTypeDto = statusType.getStatusTypeId(statusTypeID);
        if(statusTypeDto==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(statusTypeDto, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{statusTypeID}")
    public ResponseEntity<Void> deleteStatusType(@PathVariable Long statusTypeID){
        try{
            statusType.delete(statusTypeID);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateStatusType(@RequestBody StatusTypeDto statusTypeDto){
        try{
            statusType.update(statusTypeDto);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
