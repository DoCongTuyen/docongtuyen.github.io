package com.itsol.projectservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeSheetDto {
    private int id;
    private int employeeId;
    private int eprojectId;
    private String title;
    private String content;
    private String note;
    private String checker;
}
