package com.itsol.backend.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "EMPLOYEE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EMPLOYEE")
    @SequenceGenerator(sequenceName = "AUTO_INCRE_SEQ_EMPLOYEE" ,allocationSize = 1,name = "SEQ_EMPLOYEE")
    private Long id;

    @Column(name = "USERNAME", length = 50)
    private String username;

    @Column(name="FULLNAME",length = 50)
    private String fullName;

    @Column(name = "EMAIL", length = 50)
    private String email;

    @Column(name = "PASSWORD", length = 256)
    private String password;

    @Column(name = "PHONE_NUMBER")
    private String phone;

    @Column(name = "SKYPE_ACCOUNT")
    private String skype;

    @Column(name = "GRADUATED_YEAR")
    private long graduatedYear;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "UNIVERSITY")
    private String university;

    @Column(name = "IS_LEADER")
    private Long isLeader;

    @Column(name = "IS_MANAGER")
    private Long isManager;

    @Column(name = "USER_TYPE",length = 50)
    private String userType;

    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Column(name = "IS_ACTIVED")
    private int activated ;

    @Column(name = "IMAGE_URL", length = 256)
    private String imageUrl;

    @CreationTimestamp
    @Column(name = "LAST_ACCESS")
    private Date lastAccess;

    @CreationTimestamp
    @Column(name = "CREATED_DATE", updatable = false)
    private Date createdDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "POSITION_ID")
    private Position position;
    @ManyToMany
    @JoinTable(name = "EMPLOYEE_ROLE",
            joinColumns = @JoinColumn(name = "EMPLOYEE_ID",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID",referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();
}
