package com.itsol.projectservice.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;



@Entity
@Table(name = "TEAM_PROJECT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class TeamProject implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn(name = "TEAM_ID")
    private Team team;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn(name = "PROJECT_ID")
    private Project project;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "HANDOVER_DATE")
    private Date handoverDate;

}
