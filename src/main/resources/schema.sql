DROP TABLE IF EXISTS TBL_EMPLOYEES;
DROP TABLE IF EXISTS TBL_LEAVE;
DROP TABLE IF EXISTS TBL_DEPARTMENT;

CREATE TABLE TBL_LEAVE (
  id INT AUTO_INCREMENT  PRIMARY KEY,
employee_id INT ,
  leave_type VARCHAR(250) NOT NULL,
  leave_status VARCHAR(250) NOT NULL,
);

CREATE TABLE TBL_DEPARTMENT (
  id INT AUTO_INCREMENT  PRIMARY KEY,
employee_id INT ,
  dept_name VARCHAR(250) NOT NULL,
  dept_head VARCHAR(250) NOT NULL,
);


CREATE TABLE TBL_EMPLOYEES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL
);

alter table TBL_DEPARTMENT add constraint FKcaf6ht0hfw93lwc13ny0sdmvo foreign key (employee_id) references TBL_EMPLOYEES (id);

alter table TBL_LEAVE add constraint FKcaf6ht0hfw93lwc13n0sdmvo foreign key (employee_id) references TBL_EMPLOYEES (id);
