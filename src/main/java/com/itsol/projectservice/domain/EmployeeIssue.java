package com.itsol.projectservice.domain;


import javax.persistence.*;
import java.io.Serializable;

@Table(name = "EMPLOYEE_ISSUE")
public class EmployeeIssue implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ISSUE_ID")
    private Issue issue;

    @Column(name = "SPENT_TIME")
    private float spentTime;

    @Column(name = "NOTE")
    private String note;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "STATUS_ID")
    private Status status;

}
