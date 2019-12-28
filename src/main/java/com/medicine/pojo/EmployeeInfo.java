package com.medicine.pojo;

import java.io.Serializable;
import java.lang.Double;
import java.sql.Timestamp;

public class EmployeeInfo implements Serializable{
	
	private static final long serialVersionUID = 3423165156736696421L;

	private Integer employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String jobId;
	private Double salary;
	private Double commissionPct;
	private Integer managerId;
	private Integer departmentId;
	private Timestamp hiredate;
	//新增字段
	private String hiredateStr;
	private String departmentName;
	private String jobTitle;
	
	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getHiredateStr() {
		return hiredateStr;
	}

	public void setHiredateStr(String hiredateStr) {
		this.hiredateStr = hiredateStr;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Double getCommissionPct() {
		return commissionPct;
	}

	public void setCommissionPct(Double commissionPct) {
		this.commissionPct = commissionPct;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Timestamp getHiredate() {
		return hiredate;
	}

	public void setHiredate(Timestamp hiredate) {
		this.hiredate = hiredate;
	}

	public EmployeeInfo(Integer employeeId, String firstName, String lastName, String email, String phoneNumber,
			String jobId, Double salary, Double commissionPct, Integer managerId, Integer departmentId,
			Timestamp hiredate) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.jobId = jobId;
		this.salary = salary;
		this.commissionPct = commissionPct;
		this.managerId = managerId;
		this.departmentId = departmentId;
		this.hiredate = hiredate;
	}

	public EmployeeInfo() {
		super();
	}

	public EmployeeInfo(Integer employeeId, String firstName, String lastName) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	@Override

	public String toString() {
		return "EmployeeInfo [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", jobId=" + jobId + ", salary=" + salary
				+ ", commissionPct=" + commissionPct + ", managerId=" + managerId + ", departmentId=" + departmentId
				+ ", hiredate=" + hiredate + "]";
	}


}
