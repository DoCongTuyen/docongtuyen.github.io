package com.itsol.backend.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ISSUE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ISSUE")
    @SequenceGenerator(sequenceName = "AUTO_INCRE_SEQ_ISSUE", allocationSize = 1, name = "SEQ_ISSUE")
    private Long id;

    @Column(name = "NAME", length = 50)
    private String name;

    @Column(name = "START_DATE", length = 70)
    private Date startDate;

    @Column(name = "DUE_DATE", length = 250)
    private Double dueDate;

    @Column(name = "DONE_PERCENT", length = 50)
    private Long donePercent;

    @Column(name = "PRIORITY", length = 70)
    private String priority;

    @Column(name = "REASON", length = 50)
    private String reason;

    @Column(name = "DESCRIPTION", length = 50)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECT_ID")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATUS_ID")
    private Status status;

}
