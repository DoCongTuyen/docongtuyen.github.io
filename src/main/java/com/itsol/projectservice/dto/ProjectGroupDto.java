package com.itsol.projectservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectGroupDto {
    private int id;
    private String position;
    private Timestamp joinDate;
    private Timestamp outDate;
    private EmployeeDto employeeDto;
    private ProjectDto projectDto;

    private Integer userId;
    private Integer projectId;

    private Integer[] ids;
}
