//package com.itsol.projectservice.rest;
//
//import com.itsol.projectservice.domain.Eproject;
//import com.itsol.projectservice.domain.TimeSheet;
//import com.itsol.projectservice.dto.TimeSheetDto;
//import com.itsol.projectservice.service.TimeSheetService;
//import com.itsol.projectservice.service.common.InputException;
//import com.itsol.projectservice.service.common.Notification;
//import com.itsol.projectservice.service.common.SystemConstants;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(path = "/api/eproject")
//public class TimeSheetController {
//    @Autowired
//    private TimeSheetService timeSheetService;
//
//    @PostMapping(path = "/timesheet/add", consumes = SystemConstants.TYPE_JSON, produces = SystemConstants.TYPE_JSON)
//    public ResponseEntity addTimeSheet(@RequestBody TimeSheetDto timeSheetDto) {
//        String message;
//        try {
//            if (timeSheetDto.getTitle().trim().equals("")) throw new InputException("Tiêu đề không được để trống");
//            if (timeSheetDto.getContent().trim().equals("")) throw new InputException("Nội dung không được để trống");
//            message = timeSheetService.addTimeSheet(timeSheetDto);
//        } catch (InputException e) {
//            message = e.getMessage();
//        }
//
//        return ResponseEntity.ok(new Notification(200, message));
//    }
//
//    @DeleteMapping("/timesheet/delete/{timesheetId}")
//    public ResponseEntity deleteTimeSheet(@PathVariable int timesheetId) {
//        return ResponseEntity.ok(new Notification(200, timeSheetService.deleteTimeSheet(timesheetId)));
//    }
//
//    @GetMapping(path = "/timesheet/show")
//    public List<TimeSheet> showAllTimeSheet() {
//        return timeSheetService.findAll();
//    }
//
//    @PostMapping(path = "/timesheet/update",consumes = SystemConstants.TYPE_JSON, produces = SystemConstants.TYPE_JSON)
//    public ResponseEntity updateTimeSheet(@RequestBody TimeSheetDto timeSheetDto) {
//        String message;
//
//        try {
//            if (timeSheetDto.getTitle().trim().equals("")) throw new InputException("Tiêu đề không được để trống");
//            if (timeSheetDto.getContent().trim().equals("")) throw new InputException("Nội dung không được để trống");
//            message = timeSheetService.updateTimeSheet(timeSheetDto);
//        } catch (InputException e) {
//            message = e.getMessage();
//        }
//
//        return ResponseEntity.ok(new Notification(200, message));
//    }
//
//
//    @GetMapping("/timesheet/show/{employeeId}")
//    public ResponseEntity<List<TimeSheet>> showTimeSheetByEmployeeId(@PathVariable int employeeId) {
//        return ResponseEntity.ok(timeSheetService.findTimeSheetByEmployeeId(employeeId));
//    }
//
//    @GetMapping("/timesheet/{id}")
//    public ResponseEntity<TimeSheet> showTimeSheetById(@PathVariable int id) {
//        return ResponseEntity.ok(timeSheetService.findTimeSheetById(id));
//    }
//
//
//    @PostMapping(path = "/timesheet/update/check", consumes = SystemConstants.TYPE_JSON, produces = SystemConstants.TYPE_JSON)
//    public ResponseEntity<String> updateCheck(@RequestBody TimeSheetDto TimeSheetDto) {
//        return ResponseEntity.ok(timeSheetService.updateCheck(TimeSheetDto));
//    }
//
//
//    @GetMapping(path = "/timesheet/getAll")
//    public List<Eproject> getAllEproject() {
//        return timeSheetService.getEprojectList();
//    }
//}
//
