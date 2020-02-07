//package com.itsol.projectservice.repository;
//
//import com.itsol.projectservice.domain.Eproject;
//import com.itsol.projectservice.domain.TimeSheet;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//@Repository
//public interface TimeSheetRepository extends JpaRepository<TimeSheet, Integer> {
//    TimeSheet findTimeSheetById(int id);
//
//    int updateTimeSheet(String title, String content, String note, int timeSheetId);
//
//    int updateCheck(String check, int timeSheetId);
//
//    List<TimeSheet> showTimeSheetByEproject(Eproject eproject);
//
//    TimeSheet findTimeSheetByEprojectAndId(Eproject eproject, int timeSheetId);
//
//}
