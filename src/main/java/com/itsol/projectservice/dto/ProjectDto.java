package com.itsol.projectservice.dto;


import lombok.*;

import java.util.Date;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private Integer id;
    private String name;
    private Integer status;
    private Date startDate;
    private Date endDate;
    private Integer[] ids;



}
