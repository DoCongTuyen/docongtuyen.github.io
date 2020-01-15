package com.itsol.projectservice.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private long id;
    private String name;
    private StatusDto status;
}
