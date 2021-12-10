package com.example.demo.model;

import java.util.List;

public class EmployeeData {

	private String name;
	private String email;
	private List<LeaveData> leaveDetails;
	private List<DeptData> deptMapped;
	
	
	public List<LeaveData> getLeaveDetails() {
		return leaveDetails;
	}
	public void setLeaveDetails(List<LeaveData> leaveDetails) {
		this.leaveDetails = leaveDetails;
	}
	public List<DeptData> getDeptMapped() {
		return deptMapped;
	}
	public void setDeptMapped(List<DeptData> deptMapped) {
		this.deptMapped = deptMapped;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
