package com.itsol.backend.dto;

import com.itsol.backend.domain.Department;
import com.itsol.backend.domain.Position;
import com.itsol.backend.domain.Team;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private Long id;
    private String username;
    private String password;
    private String fullName;
    private String userType;
    private String email;
    private String phone;
    private String skype;
    private long graduatedYear;
    private String address;
    private String university;
    private Date birthday;
    private int activated;
    private String imageUrl;
    private Date lastAccess;
    private Date createdDate;
    private long isLeader;
    private long isManager;
    private Long positionId;
    private Long teamId;
    private Long departmentId;
}
