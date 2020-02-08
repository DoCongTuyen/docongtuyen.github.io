--CREATE TABLE

CREATE TABLE role (
    id     NUMBER(10) PRIMARY KEY,
    name   VARCHAR2(255) NOT NULL
);

CREATE TABLE employee_role (
    employee_id   NUMBER(10) NOT NULL,
    role_id       NUMBER(10) NOT NULL,
    PRIMARY KEY ( employee_id,
                  role_id )
);

CREATE TABLE department (
    id           NUMBER(10) PRIMARY KEY,
    manager_id   NUMBER(10) NOT NULL,
    name         VARCHAR2(255) NOT NULL,
    location     VARCHAR2(255) NOT NULL
);

CREATE TABLE status_type (
    id     NUMBER(10) PRIMARY KEY,
    name   VARCHAR2(255)
);

CREATE TABLE status (
    id        NUMBER(10) PRIMARY KEY,
    name      VARCHAR2(255) NOT NULL,
    type_id   NUMBER(10) NOT NULL
);

CREATE TABLE position (
    id     NUMBER(10) PRIMARY KEY,
    name   VARCHAR2(255)
);

CREATE TABLE absent (
    id                  NUMBER(10) PRIMARY KEY,
    person_absent_id    NUMBER(10) NOT NULL,
    person_approve_id   NUMBER(10) NOT NULL,
    number_day          NUMBER(5) NOT NULL,
    reason              VARCHAR2(1000) NOT NULL,
    status_id           NUMBER(10) NOT NULL
);

CREATE TABLE project (
    id          NUMBER(10) PRIMARY KEY,
    name        VARCHAR2(255),
    status_id   NUMBER(10) NOT NULL
);

CREATE TABLE team_project (
    team_id         NUMBER(10) NOT NULL,
    project_id      NUMBER(10) NOT NULL,
    start_date      DATE NOT NULL,
    handover_date   DATE NOT NULL,
    PRIMARY KEY ( team_id,
                  project_id )
);

CREATE TABLE team (
    id          NUMBER(10) PRIMARY KEY,
    leader_id   NUMBER(10) NOT NULL
);

CREATE TABLE employee_issue (
    employee_id   NUMBER(10) NOT NULL,
    issue_id       NUMBER(10) NOT NULL,
    spent_time    FLOAT(10) NOT NULL,
    note          VARCHAR2(1000),
    status_id     NUMBER(10) NOT NULL,
    PRIMARY KEY ( employee_id,
                  issue_id )
);

CREATE TABLE issue (
    id             NUMBER(10) PRIMARY KEY,
    name           VARCHAR2(255) NOT NULL,
    start_date     DATE NOT NULL,
    due_date       NUMBER(10,2) NOT NULL,
    done_percent   NUMBER(10) NOT NULL,
    priority       VARCHAR2(500) NOT NULL,
    reason         VARCHAR2(1000) NOT NULL,
    description    VARCHAR2(500),
    type           VARCHAR2(255) NOT NULL,
    project_id     NUMBER(10) NOT NULL,
    status_id      NUMBER(10) NOT NULL
);

CREATE TABLE employee (
    id               NUMBER(10) NOT NULL PRIMARY KEY,
    username         VARCHAR2(255) NOT NULL,
    password         VARCHAR2(255) NOT NULL,
    image_url        VARCHAR2(255),
    last_access      DATE NOT NULL,
    fullname         VARCHAR2(255) NOT NULL,
    created_date     DATE NOT NULL,
    email            VARCHAR2(255) NOT NULL UNIQUE,
    phone_number     VARCHAR2(255),
    skype_account    VARCHAR2(255) NOT NULL UNIQUE,
    user_type        VARCHAR2(255) NOT NULL,
    address          VARCHAR2(255),
    university      VARCHAR2(255),
    graduated_year   NUMBER(5),
    is_leader        NUMBER(2),
    is_manager       number(2),
    is_actived       NUMBER(2),
    position_id      NUMBER(10) ,
    team_id          NUMBER(10) ,
    department_id    NUMBER(10) ,
	birthday 		 DATE
);

CREATE TABLE issue_history (
    id                 NUMBER(10) PRIMARY KEY,
    update_date        DATE NOT NULL,
    comments            VARCHAR2(255),
    issue_change        VARCHAR2(4000),
    issue_id            NUMBER(10) NOT NULL,
    update_person_id   NUMBER(10) NOT NULL
);

--ADD CONSTRAINT

ALTER TABLE employee_role ADD CONSTRAINT employee_role_role_fk FOREIGN KEY (role_id) REFERENCES role (id) ON DELETE CASCADE;
ALTER TABLE employee ADD CONSTRAINT employee_position_fk FOREIGN KEY (position_id) REFERENCES position (id) ON DELETE CASCADE ;
ALTER TABLE employee_issue ADD CONSTRAINT employee_issue_employee_fk FOREIGN KEY (employee_id) REFERENCES employee (id);
ALTER TABLE status ADD CONSTRAINT status_status_type_fk FOREIGN KEY (type_id) REFERENCES status_type (id) ON DELETE CASCADE;
ALTER TABLE employee_issue ADD CONSTRAINT employee_issue_issue_fk FOREIGN KEY (issue_id) REFERENCES issue (id);
ALTER TABLE issue ADD CONSTRAINT issue_project_fk FOREIGN KEY (project_id) REFERENCES project (id) ON DELETE CASCADE;
ALTER TABLE issue_history ADD CONSTRAINT issue_history_issue_fk FOREIGN KEY (issue_id) REFERENCES issue (id);
ALTER TABLE issue ADD CONSTRAINT issue_status_fk FOREIGN KEY (status_id) REFERENCES status (id) ON DELETE CASCADE;
ALTER TABLE project ADD CONSTRAINT project_status_fk FOREIGN KEY (status_id) REFERENCES status (id);
ALTER TABLE issue_history ADD CONSTRAINT issue_history_employee_fk FOREIGN KEY (update_person_id) REFERENCES employee (id);
ALTER TABLE team_project ADD CONSTRAINT team_project_team_fk FOREIGN KEY (team_id) REFERENCES team (id);
ALTER TABLE team_project ADD CONSTRAINT team_project_project_fk FOREIGN KEY (project_id) REFERENCES project (id);
ALTER TABLE absent ADD CONSTRAINT absent_employee_fk FOREIGN KEY (person_absent_id) REFERENCES employee (id) ON DELETE CASCADE;
ALTER TABLE absent ADD CONSTRAINT absent_employee1_fk FOREIGN KEY (person_approve_id) REFERENCES employee (id) ON DELETE CASCADE;
ALTER TABLE absent ADD CONSTRAINT absent_status_fk FOREIGN KEY (status_id) REFERENCES status (id) ON DELETE CASCADE;
ALTER TABLE employee_role ADD CONSTRAINT employee_role_employee_fk FOREIGN KEY (employee_id) REFERENCES employee (id) ON DELETE CASCADE;
ALTER TABLE employee ADD CONSTRAINT employee_department_fk FOREIGN KEY (department_id) REFERENCES department (id) ON DELETE CASCADE;
ALTER TABLE employee_issue ADD CONSTRAINT employee_issue_status_fk FOREIGN KEY (status_id) REFERENCES status (id);
ALTER TABLE employee ADD CONSTRAINT employee_team_fk FOREIGN KEY (team_id) REFERENCES team (id) ON DELETE CASCADE;


--create sequence
CREATE SEQUENCE AUTO_INCRE_SEQ_ABSENT
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE AUTO_INCRE_SEQ_DEPARTMENT
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE AUTO_INCRE_SEQ_EMPLOYEE
START WITH 1
INCREMENT BY 1;


CREATE SEQUENCE AUTO_INCRE_SEQ_ISSUE
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE AUTO_INCRE_SEQ_ISSUE_HIS
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE AUTO_INCRE_SEQ_POSITION
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE AUTO_INCRE_SEQ_PROJECT
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE AUTO_INCRE_SEQ_ROLE
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE AUTO_INCRE_SEQ_STATUS
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE AUTO_INCRE_SEQ_STATUS_TYPE
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE AUTO_INCRE_SEQ_TEAM
START WITH 1
INCREMENT BY 1;


--DEMO DATA

INSERT INTO "SYSTEM1"."ROLE" (ID, NAME) VALUES (AUTO_INCRE_SEQ_ROLE.nextval, 'MEMBER');
INSERT INTO "SYSTEM1"."ROLE" (ID, NAME) VALUES (AUTO_INCRE_SEQ_ROLE.nextval, 'LEADER');
INSERT INTO "SYSTEM1"."ROLE" (ID, NAME) VALUES (AUTO_INCRE_SEQ_ROLE.nextval, 'MANAGER');
INSERT INTO "SYSTEM1"."ROLE" (ID, NAME) VALUES (AUTO_INCRE_SEQ_ROLE.nextval, 'HR');
commit;

INSERT INTO "SYSTEM1"."POSITION" (ID, NAME) VALUES (AUTO_INCRE_SEQ_POSITION.nextval, 'Nhân Viên');
INSERT INTO "SYSTEM1"."POSITION" (ID, NAME) VALUES (AUTO_INCRE_SEQ_POSITION.nextval, 'Trưởng nhóm');
INSERT INTO "SYSTEM1"."POSITION" (ID, NAME) VALUES (AUTO_INCRE_SEQ_POSITION.nextval, 'Quản lý');
INSERT INTO "SYSTEM1"."POSITION" (ID, NAME) VALUES (AUTO_INCRE_SEQ_POSITION.nextval, 'Nhân sự');
commit;

INSERT INTO "SYSTEM1"."DEPARTMENT" (ID, MANAGER_ID, NAME, LOCATION) VALUES (AUTO_INCRE_SEQ_DEPARTMENT.nextval, '02', 'Tester', 'Hà Nội');
INSERT INTO "SYSTEM1"."DEPARTMENT" (ID, MANAGER_ID, NAME, LOCATION) VALUES (AUTO_INCRE_SEQ_DEPARTMENT.nextval, '03', 'Developer', 'Hà Nội');
INSERT INTO "SYSTEM1"."DEPARTMENT" (ID, MANAGER_ID, NAME, LOCATION) VALUES (AUTO_INCRE_SEQ_DEPARTMENT.nextval, '04', 'Human Resources', 'Hà Nội');
commit;

INSERT INTO "SYSTEM1"."STATUS_TYPE" (ID, NAME) VALUES (AUTO_INCRE_SEQ_STATUS_TYPE.nextval, 'issue_status');
INSERT INTO "SYSTEM1"."STATUS_TYPE" (ID, NAME) VALUES (AUTO_INCRE_SEQ_STATUS_TYPE.nextval, 'project_status');
INSERT INTO "SYSTEM1"."STATUS_TYPE" (ID, NAME) VALUES (AUTO_INCRE_SEQ_STATUS_TYPE.nextval, 'timesheet_status');
INSERT INTO "SYSTEM1"."STATUS_TYPE" (ID, NAME) VALUES (AUTO_INCRE_SEQ_STATUS_TYPE.nextval, 'absent_status');
commit;

INSERT INTO "SYSTEM1"."STATUS" (ID, NAME, TYPE_ID) VALUES (AUTO_INCRE_SEQ_STATUS.nextval, 'New', '1');
INSERT INTO "SYSTEM1"."STATUS" (ID, NAME, TYPE_ID) VALUES (AUTO_INCRE_SEQ_STATUS.nextval, 'In Progress', '1');
INSERT INTO "SYSTEM1"."STATUS" (ID, NAME, TYPE_ID) VALUES (AUTO_INCRE_SEQ_STATUS.nextval, 'Resolved', '1');
INSERT INTO "SYSTEM1"."STATUS" (ID, NAME, TYPE_ID) VALUES (AUTO_INCRE_SEQ_STATUS.nextval, 'Reopen', '1');
INSERT INTO "SYSTEM1"."STATUS" (ID, NAME, TYPE_ID) VALUES (AUTO_INCRE_SEQ_STATUS.nextval, 'Closed', '1');
INSERT INTO "SYSTEM1"."STATUS" (ID, NAME, TYPE_ID) VALUES (AUTO_INCRE_SEQ_STATUS.nextval, 'Next Release', '1');
INSERT INTO "SYSTEM1"."STATUS" (ID, NAME, TYPE_ID) VALUES (AUTO_INCRE_SEQ_STATUS.nextval, 'Build', '1');
INSERT INTO "SYSTEM1"."STATUS" (ID, NAME, TYPE_ID) VALUES (AUTO_INCRE_SEQ_STATUS.nextval, 'Task', '3');
INSERT INTO "SYSTEM1"."STATUS" (ID, NAME, TYPE_ID) VALUES (AUTO_INCRE_SEQ_STATUS.nextval, 'Request', '3');
INSERT INTO "SYSTEM1"."STATUS" (ID, NAME, TYPE_ID) VALUES (AUTO_INCRE_SEQ_STATUS.nextval, 'Bug', '3');
INSERT INTO "SYSTEM1"."STATUS" (ID, NAME, TYPE_ID) VALUES (AUTO_INCRE_SEQ_STATUS.nextval, 'Feature', '3');
INSERT INTO "SYSTEM1"."STATUS" (ID, NAME, TYPE_ID) VALUES (AUTO_INCRE_SEQ_STATUS.nextval, 'New', '2');
INSERT INTO "SYSTEM1"."STATUS" (ID, NAME, TYPE_ID) VALUES (AUTO_INCRE_SEQ_STATUS.nextval, 'In Progress', '2');
INSERT INTO "SYSTEM1"."STATUS" (ID, NAME, TYPE_ID) VALUES (AUTO_INCRE_SEQ_STATUS.nextval, 'Closed', '2');
INSERT INTO "SYSTEM1"."STATUS" (ID, NAME, TYPE_ID) VALUES (AUTO_INCRE_SEQ_STATUS.nextval, 'Reopen', '2');
INSERT INTO "SYSTEM1"."STATUS" (ID, NAME, TYPE_ID) VALUES (AUTO_INCRE_SEQ_STATUS.nextval, 'Nghỉ', '4');
INSERT INTO "SYSTEM1"."STATUS" (ID, NAME, TYPE_ID) VALUES (AUTO_INCRE_SEQ_STATUS.nextval, 'Vắng', '4');
INSERT INTO "SYSTEM1"."STATUS" (ID, NAME, TYPE_ID) VALUES (AUTO_INCRE_SEQ_STATUS.nextval, 'Đi muộn', '4');
INSERT INTO "SYSTEM1"."STATUS" (ID, NAME, TYPE_ID) VALUES (AUTO_INCRE_SEQ_STATUS.nextval, 'Về sớm', '4');
commit;

insert into "SYSTEM1"."TEAM" (id,leader_id) values (AUTO_INCRE_SEQ_TEAM.nextval, 1);
insert into "SYSTEM1"."TEAM" (id,leader_id) VALUES (AUTO_INCRE_SEQ_TEAM.nextval, 2);
insert into "SYSTEM1"."TEAM" (id,leader_id) values (AUTO_INCRE_SEQ_TEAM.nextval, 4);
commit;

INSERT INTO "SYSTEM1"."PROJECT" (id, name,status_id ) VALUES (AUTO_INCRE_SEQ_PROJECT.nextval, 'Smart Shop', 12);
INSERT INTO "SYSTEM1"."PROJECT" (id, name,status_id ) VALUES (AUTO_INCRE_SEQ_PROJECT.nextval, 'Smart Ofice', 14);
INSERT INTO "SYSTEM1"."PROJECT" (id, name,status_id ) VALUES (AUTO_INCRE_SEQ_PROJECT.nextval, 'Salary Web', 13);
commit;

insert into "SYSTEM1"."TEAM_PROJECT" (team_id,project_id,start_date,handover_date ) values (3, 2,to_date('29/1/2019','dd/MM/yyyy'), to_date('30/11/2019','dd/MM/yyyy'));
insert into "SYSTEM1"."TEAM_PROJECT"(team_id,project_id,start_date,handover_date ) values (2, 2,to_date('19/1/2019','dd/MM/yyyy'), to_date('30/6/2019','dd/MM/yyyy'));
insert into "SYSTEM1"."TEAM_PROJECT" (team_id,project_id,start_date,handover_date )values (1, 3,to_date('7/2/2019','dd/MM/yyyy'), to_date('3/8/2019','dd/MM/yyyy'));
insert into "SYSTEM1"."TEAM_PROJECT" (team_id,project_id,start_date,handover_date )values (1, 1,to_date('8/2/2019','dd/MM/yyyy'), to_date('17/12/2019','dd/MM/yyyy'));
insert into "SYSTEM1"."TEAM_PROJECT"(team_id,project_id,start_date,handover_date ) values (3, 3,to_date('20/6/2019','dd/MM/yyyy'), to_date('30/11/2019','dd/MM/yyyy'));
commit;

INSERT INTO "SYSTEM1"."EMPLOYEE" (ID, USERNAME,
PASSWORD,image_url,last_access, FULLNAME,created_date, EMAIL, PHONE_NUMBER, SKYPE_ACCOUNT, USER_TYPE, ADDRESS, UNIVERSITY, GRADUATED_YEAR, IS_ACTIVED, POSITION_ID, TEAM_ID, DEPARTMENT_ID,IS_MANAGER, IS_LEADER, BIRTHDAY)
VALUES (AUTO_INCRE_SEQ_EMPLOYEE.nextval, 'dungdq96', '123456', null, to_date('29/12/2019', 'dd/MM/yyyy'),'Đỗ Quang Dũng',to_date('19/5/2019','dd/MM/yyyy'),
'dungdq96@gmail.com', '0986198276', 'dungdq96', 'Nhân viên', 'Hà Nội', 'PTIT', '2019', '1', '2', '2', '2','0','1',to_date('30/12/1997','dd/MM/yyyy'));

INSERT INTO "SYSTEM1"."EMPLOYEE" (ID, USERNAME,
PASSWORD,image_url,last_access, FULLNAME,created_date, EMAIL, PHONE_NUMBER, SKYPE_ACCOUNT, USER_TYPE, ADDRESS, UNIVERSITY, GRADUATED_YEAR, IS_ACTIVED, POSITION_ID, TEAM_ID, DEPARTMENT_ID,IS_MANAGER, IS_LEADER, BIRTHDAY)
VALUES (AUTO_INCRE_SEQ_EMPLOYEE.nextval, 'tranvancuong97', '123456', null, to_date('31/12/2019', 'dd/MM/yyyy'),'Trần Văn Cường',to_date('9/5/2019','dd/MM/yyyy'),
'tranvancuong97@gmail.com', '0976182712', 'trancuong97', 'Nhân viên', 'Hà Nội', 'Freelancer', '2014', '1', '2', '1', '3','0','1',to_date('12/12/1999','dd/MM/yyyy'));

INSERT INTO "SYSTEM1"."EMPLOYEE" (ID, USERNAME,
PASSWORD,image_url,last_access, FULLNAME,created_date, EMAIL, PHONE_NUMBER, SKYPE_ACCOUNT, USER_TYPE, ADDRESS, UNIVERSITY, GRADUATED_YEAR, IS_ACTIVED, POSITION_ID, TEAM_ID, DEPARTMENT_ID,IS_MANAGER, IS_LEADER, BIRTHDAY)
VALUES (AUTO_INCRE_SEQ_EMPLOYEE.nextval, 'dttthao21', '123456', null, to_date('10/12/2019', 'dd/MM/yyyy'),'Đặng Thị Thu Thảo',to_date('7/7/2019','dd/MM/yyyy'),
'dttthao@yahoo.com', '0985261726', 'dtthao', 'Học việc', 'Thái Bình', 'HNU', '2018', '1', '4', '2', '3','0','0',to_date('1/6/1997','dd/MM/yyyy'));

INSERT INTO "SYSTEM1"."EMPLOYEE" (ID, USERNAME,
PASSWORD,image_url,last_access, FULLNAME,created_date, EMAIL, PHONE_NUMBER, SKYPE_ACCOUNT, USER_TYPE, ADDRESS, UNIVERSITY, GRADUATED_YEAR, IS_ACTIVED, POSITION_ID, TEAM_ID, DEPARTMENT_ID,IS_MANAGER, IS_LEADER, BIRTHDAY)
VALUES (AUTO_INCRE_SEQ_EMPLOYEE.nextval, 'dinhquang', '123456', null, to_date('17/12/2019', 'dd/MM/yyyy'),'Trịnh Đình Quang',to_date('19/10/2017','dd/MM/yyyy'),
'dinhquang@itsol.com', '0981267271', 'dinhquang1', 'Nhân viên', 'Hà Nội', 'HUST', '2018', '1', '3', '2', '1','1','1',to_date('8/12/1993','dd/MM/yyyy'));

INSERT INTO "SYSTEM1"."EMPLOYEE" (ID, USERNAME,
PASSWORD,image_url,last_access, FULLNAME,created_date, EMAIL, PHONE_NUMBER, SKYPE_ACCOUNT, USER_TYPE, ADDRESS, UNIVERSITY, GRADUATED_YEAR, IS_ACTIVED, POSITION_ID, TEAM_ID, DEPARTMENT_ID,IS_MANAGER, IS_LEADER, BIRTHDAY)
VALUES (AUTO_INCRE_SEQ_EMPLOYEE.nextval, 'tonthang1', '123456', null, to_date('8/12/2019', 'dd/MM/yyyy'),'Tôn Đức Thắng',to_date('19/11/2017','dd/MM/yyyy'),
'tonthang1@itsol.com', '036928127', 'tonthang32', 'Nhân viên', 'Hà Nội', 'PTIT', '2018', '1', '3', '1', '3','1','0',to_date('9/8/1999','dd/MM/yyyy'));

INSERT INTO "SYSTEM1"."EMPLOYEE" (ID, USERNAME,
PASSWORD,image_url,last_access, FULLNAME,created_date, EMAIL, PHONE_NUMBER, SKYPE_ACCOUNT, USER_TYPE, ADDRESS, UNIVERSITY, GRADUATED_YEAR, IS_ACTIVED, POSITION_ID, TEAM_ID, DEPARTMENT_ID,IS_MANAGER, IS_LEADER, BIRTHDAY)
VALUES (AUTO_INCRE_SEQ_EMPLOYEE.nextval, 'dangan9', '123456', null, to_date('10/10/2018', 'dd/MM/yyyy'),'Đặng Thế An',to_date('20/12/2018','dd/MM/yyyy'),
'dangan@gmail.com', '037827192', 'dangan93', 'Nhân viên', 'Hà Nội', 'HUS', '2017', '1', '1', '2', '2','0','0',to_date('18/11/1993','dd/MM/yyyy'));

INSERT INTO "SYSTEM1"."EMPLOYEE" (ID, USERNAME,
PASSWORD,image_url,last_access, FULLNAME,created_date, EMAIL, PHONE_NUMBER, SKYPE_ACCOUNT, USER_TYPE, ADDRESS, UNIVERSITY, GRADUATED_YEAR, IS_ACTIVED, POSITION_ID, TEAM_ID, DEPARTMENT_ID,IS_MANAGER, IS_LEADER, BIRTHDAY)
VALUES (AUTO_INCRE_SEQ_EMPLOYEE.nextval, 'ngkhanhvan1', '654321', null, to_date('8/8/2019', 'dd/MM/yyyy'),'Nguyễn Khánh Vân',to_date('9/5/2019','dd/MM/yyyy'),
'ngkhvan@yahoo.com', '0897672516', 'nkvan98', 'Thực tập', 'Hà Giang', 'VNU', '2018', '0', '4', '3', '1','0','0',to_date('19/1/1999','dd/MM/yyyy'));

INSERT INTO "SYSTEM1"."EMPLOYEE" (ID, USERNAME,
PASSWORD,image_url,last_access, FULLNAME,created_date, EMAIL, PHONE_NUMBER, SKYPE_ACCOUNT, USER_TYPE, ADDRESS, UNIVERSITY, GRADUATED_YEAR, IS_ACTIVED, POSITION_ID, TEAM_ID, DEPARTMENT_ID,IS_MANAGER, IS_LEADER, BIRTHDAY)
VALUES (AUTO_INCRE_SEQ_EMPLOYEE.nextval, 'daothang98', '654321', null, to_date('7/2/2019', 'dd/MM/yyyy'),'Đào Đức Thắng',to_date('19/1/2019','dd/MM/yyyy'),
'daothang@outlook.com', '036928127', 'daothang8', 'Sinh viên', 'Hà Nội', 'HUST', '2019', '0', '1', '3', '1','0','0',to_date('30/5/1998','dd/MM/yyyy'));
commit;


INSERT INTO "SYSTEM1"."EMPLOYEE_ROLE" (EMPLOYEE_ID, ROLE_ID) VALUES ('1', '1');
INSERT INTO "SYSTEM1"."EMPLOYEE_ROLE" (EMPLOYEE_ID, ROLE_ID) VALUES ('2', '1');
INSERT INTO "SYSTEM1"."EMPLOYEE_ROLE" (EMPLOYEE_ID, ROLE_ID) VALUES ('3', '1');
INSERT INTO "SYSTEM1"."EMPLOYEE_ROLE" (EMPLOYEE_ID, ROLE_ID) VALUES ('4', '1');
INSERT INTO "SYSTEM1"."EMPLOYEE_ROLE" (EMPLOYEE_ID, ROLE_ID) VALUES ('5', '1');
INSERT INTO "SYSTEM1"."EMPLOYEE_ROLE" (EMPLOYEE_ID, ROLE_ID) VALUES ('6', '1');
INSERT INTO "SYSTEM1"."EMPLOYEE_ROLE" (EMPLOYEE_ID, ROLE_ID) VALUES ('7', '1');
INSERT INTO "SYSTEM1"."EMPLOYEE_ROLE" (EMPLOYEE_ID, ROLE_ID) VALUES ('8', '1');
INSERT INTO "SYSTEM1"."EMPLOYEE_ROLE" (EMPLOYEE_ID, ROLE_ID) VALUES ('1', '2');
INSERT INTO "SYSTEM1"."EMPLOYEE_ROLE" (EMPLOYEE_ID, ROLE_ID) VALUES ('2', '2');
INSERT INTO "SYSTEM1"."EMPLOYEE_ROLE" (EMPLOYEE_ID, ROLE_ID) VALUES ('4', '2');
INSERT INTO "SYSTEM1"."EMPLOYEE_ROLE" (EMPLOYEE_ID, ROLE_ID) VALUES ('4', '3');
INSERT INTO "SYSTEM1"."EMPLOYEE_ROLE" (EMPLOYEE_ID, ROLE_ID) VALUES ('5', '3');
INSERT INTO "SYSTEM1"."EMPLOYEE_ROLE" (EMPLOYEE_ID, ROLE_ID) VALUES ('3', '4');
INSERT INTO "SYSTEM1"."EMPLOYEE_ROLE" (EMPLOYEE_ID, ROLE_ID) VALUES ('7', '4');
commit;



INSERT INTO "SYSTEM1"."ISSUE" (ID, NAME, start_date, due_date, DONE_PERCENT, PRIORITY, REASON, DESCRIPTION, TYPE, PROJECT_ID, STATUS_ID)
VALUES (AUTO_INCRE_SEQ_ISSUE.nextval, 'Không tự động chuyển trang ',to_date('19/6/2019','dd/MM/yyyy'),'2.5', '80', 'Trung bình', 'Chưa tìm ra', 'Khi bấm vào số trang ở thanh chuyển trang thì không có hành động nào xảy ra', 'Bug', '2', '2');

INSERT INTO "SYSTEM1"."ISSUE" (ID, NAME, start_date, due_date, DONE_PERCENT, PRIORITY, REASON, DESCRIPTION, TYPE, PROJECT_ID, STATUS_ID)
VALUES (AUTO_INCRE_SEQ_ISSUE.nextval, 'Dịch sai từ tiếng Anh sang tiếng Việt ',to_date('16/10/2019','dd/MM/yyyy'),'0.5', '90', 'Dễ', 'Do chị Google lỗi', 'Issue được dịch thành "giấy ăn"', 'Bug', '1', '3');

INSERT INTO "SYSTEM1"."ISSUE" (ID, NAME, start_date, due_date, DONE_PERCENT, PRIORITY, REASON, DESCRIPTION, TYPE, PROJECT_ID, STATUS_ID)
VALUES (AUTO_INCRE_SEQ_ISSUE.nextval, 'Không nhận được thông báo khi đăng ký thành công tài khoản ',to_date('10/7/2019','dd/MM/yyyy'),'3.0', '80', 'Khó', 'Chưa tìm ra', 'Khi đăng ký thành công tài khoản phải có thông báo đến email đã đăng ký', 'Bug', '2', '3');
commit;

-- drop table issue_history;
-- drop table employee_issue;
-- drop table issue;
-- drop table absent;
-- drop table employee_role;
-- drop table team_project;
-- drop table project;
-- drop table status;
-- drop table status_type;
-- drop table role;
-- drop table employee;
-- drop table team;
-- drop table position;
-- drop table department;
--
-- --drop sequence
-- drop sequence AUTO_INCRE_SEQ_ABSENT;
-- drop sequence AUTO_INCRE_SEQ_DEPARTMENT;
-- drop sequence AUTO_INCRE_SEQ_EMPLOYEE;
-- drop sequence AUTO_INCRE_SEQ_ISSUE;
-- drop sequence AUTO_INCRE_SEQ_ISSUE_HIS;
-- drop sequence AUTO_INCRE_SEQ_POSITION;
-- drop sequence AUTO_INCRE_SEQ_PROJECT;
-- drop sequence AUTO_INCRE_SEQ_ROLE;
-- drop sequence AUTO_INCRE_SEQ_STATUS;
-- drop sequence AUTO_INCRE_SEQ_STATUS_TYPE;
-- drop sequence AUTO_INCRE_SEQ_TEAM;