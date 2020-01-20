package com.itsol.projectservice.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {

    private long id;
    private Integer managerId;
    private String name;
    private String location;
}
