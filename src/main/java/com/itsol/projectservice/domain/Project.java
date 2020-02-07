package com.itsol.projectservice.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PROJECT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTO_INCRE_SEQ_PROJECT")
    @SequenceGenerator(sequenceName = "AUTO_INCRE_SEQ_PROJECT", allocationSize = 1, name = "AUTO_INCRE_SEQ_PROJECT")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "STARTDATE")
    private Date startDate;

    @Column(name = "ENDDATE")
    private Date endDate;

    @Column(name = "STATUS")
    private Integer status;



}
