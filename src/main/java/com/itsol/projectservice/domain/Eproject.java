package com.itsol.projectservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "eproject")
public class Eproject {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "position")
    private String position;

    @Column(name = "joindate")
    private Timestamp joinDate;

    @Column(name = "outdate")
    private Timestamp outDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER)
    private Project project;

    @JsonIgnore
    @OneToMany(mappedBy = "eproject", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TimeSheet> timeSheetList = new ArrayList<>();
}
