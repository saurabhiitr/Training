package com.tbitsglobal;

import java.io.Serializable;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.codehaus.jackson.annotate.JsonTypeInfo;


@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@PersistenceCapable(detachable = "true",table="employee")
//@Index(name = "client_id_idx", members = {"empId"})
public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Persistent(primaryKey = "true")
	private long empId;
	
	@Column(jdbcType = "VARCHAR", length = 45)
//    @Unique(name = "unique_clientname")
	private String empName;

	public Employee(){}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + "]";
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Employee(long empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}
	
}
