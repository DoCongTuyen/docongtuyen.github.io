//package com.itsol.projectservice.service.Impl;
//
//import com.itsol.projectservice.domain.Employee;
//import com.itsol.projectservice.domain.Eproject;
//import com.itsol.projectservice.domain.TimeSheet;
//import com.itsol.projectservice.dto.TimeSheetDto;
//import com.itsol.projectservice.repository.EProjectRepository;
//import com.itsol.projectservice.repository.EmployeeRepository;
//import com.itsol.projectservice.repository.TimeSheetRepository;
//import com.itsol.projectservice.service.TimeSheetService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class TimeSheetServiceImpl implements TimeSheetService {
//
//    Logger logger = LoggerFactory.getLogger(TimeSheetServiceImpl.class);
//    @Autowired
//    TimeSheetRepository timeSheetRepository;
//    @Autowired
//    EProjectRepository eProjectRepository;
//    @Autowired
//    EmployeeRepository employeeRepository;
//
//    @Override
//    public String addTimeSheet(TimeSheetDto timeSheetDto) {
//        logger.trace("Service add timesheet");
//        String message="";
//        Employee employee = employeeRepository.findEmployeeById(timeSheetDto.getEmployeeId());
//        Eproject eproject = eProjectRepository.findEprojectByIdAndEmployee(timeSheetDto.getEprojectId(), employee);
//        if (eproject != null) {
//
//            TimeSheet timeSheet1 = new TimeSheet();
//            timeSheet1.setTitle(timeSheetDto.getTitle());
//            timeSheet1.setContent(timeSheetDto.getContent());
//            timeSheet1.setNote(timeSheetDto.getNote());
//            timeSheet1.setEproject(eproject);
//            timeSheet1.setChecker("unapproved");
//            timeSheet1.setStatus(true);
//
//            TimeSheet timeSheet = timeSheetRepository.save(timeSheet1);
//            if (timeSheet != null) {
//                message = "Insert Time Sheet success";
//            } else {
//                message = "Insert Time Sheet failed";
//            }
//        } else {
//            message = "Eproject does not exist";
//        }
//        return message;
//    }
//
//    @Override
//    public String deleteTimeSheet(int timeSheetId) {
//        logger.info("deleteTimeSheet");
//        String message="";
//        TimeSheet timeSheet = timeSheetRepository.findTimeSheetById(timeSheetId);
//        if (timeSheet != null) {
//            timeSheetRepository.delete(timeSheet);
//            if (timeSheetRepository.findTimeSheetById(timeSheetId) == null) {
//                message = "Delete success";
//            } else {
//                message = "Delete failed";
//            }
//        } else {
//            message = "Time Sheet does not exist";
//        }
//        return message;
//    }
//
//    @Override
//    public List<TimeSheet> findAll() {
//        return timeSheetRepository.findAll();
//    }
//
//    @Override
//    public String updateTimeSheet(TimeSheetDto TimeSheetDto) {
//        logger.info("updateTimeSheet");
//
//        String message="`";
//        Employee employee = employeeRepository.findEmployeeById(TimeSheetDto.getEmployeeId());
//        Eproject eproject = eProjectRepository.findEprojectByEmployee(employee);
//        TimeSheet timeSheet = timeSheetRepository.findTimeSheetByEprojectAndId(eproject, TimeSheetDto.getId());
//        if (eproject != null) {
//            if (timeSheet != null) {
//                int i = timeSheetRepository.updateTimeSheet(TimeSheetDto.getTitle(), TimeSheetDto.getContent()
//                        , TimeSheetDto.getNote(), TimeSheetDto.getId());
//                if (i == 1) {
//                    message = "Update success";
//                } else {
//                    message = "Update failed";
//                }
//            } else {
//                message = "TimeSheet does not exist";
//            }
//        } else {
//            message = "Eproject does not exist";
//        }
//        return message;
//    }
//
//    @Override
//    public String updateCheck(TimeSheetDto TimeSheetDto) {
//
//        logger.info("updateCheck");
//        String message="";
//        int i = timeSheetRepository.updateCheck(TimeSheetDto.getChecker(), TimeSheetDto.getId());
//        if (i == 1) {
//            message = "Success";
//        } else {
//            message = "Failed";
//        }
//        return message;
//    }
//
//    @Override
//    public List<TimeSheet> findTimeSheetByEmployeeId(int employeeId) {
//        Employee employee = employeeRepository.findEmployeeById(employeeId);
//        Eproject eproject = eProjectRepository.findEprojectByEmployee(employee);
//        if (employee != null && eproject != null && timeSheetRepository.showTimeSheetByEproject(eproject) != null) {
//            return timeSheetRepository.showTimeSheetByEproject(eproject);
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public TimeSheet findTimeSheetById(int id) {
//        return timeSheetRepository.findTimeSheetById(id);
//    }
//
//    @Override
//    public List<Eproject> getEprojectList() {
//        return eProjectRepository.findAll();
//    }
//}
