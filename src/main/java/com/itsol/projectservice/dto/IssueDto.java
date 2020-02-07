package com.itsol.projectservice.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IssueDto {
    private long id;
    private Date startDate;
    private double dueDate;
    private long donePercent;
    private String priority;
    private String reason;
    private String description;
    private ProjectDto project;
}
