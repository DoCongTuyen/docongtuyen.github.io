package com.itsol.projectservice.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private long id;
    private String username;
    private String email;
    private String phone;
    private String skype;
    private long graduatedYear;
    private String address;
    private String university;
    private Date birthday;
    private Boolean activated;
    private String imageUrl;
    private Date lastAccess;
    private Date createdDate;
}
