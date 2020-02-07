package com.itsol.projectservice.dto;

import com.itsol.projectservice.domain.Team;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TeamProjectDto {
    private Timestamp startDate;
    private Timestamp handoverDate;

}
