INSERT INTO 
	TBL_EMPLOYEES (first_name, last_name, email) 
VALUES
  	('Sam', 'j', 'abc@gmail.com'),
  	('John', 'j', 'xyz@email.com');


INSERT INTO 
	TBL_LEAVE (employee_id , leave_type, leave_status) 
VALUES
  	(1, 'Earned Leave', 'Approved'),
  	(1, 'Casual Leave', 'Approved'),
(2, 'Earned Leave', 'Approved'),
  	(2, 'Casual Leave', 'Approved');



INSERT INTO 
	TBL_DEPARTMENT (employee_id , dept_name, dept_head) 
VALUES
  	(1, 'Finance', 'Shankar'),
  	(1, 'HR', 'Ramesh'),
(2, 'Finance', 'Shankar'),
  	(2, 'HR', 'Ramesh');