package com.oms.work;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Work {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long workId;
	
	@NotNull
	long employeeId;
	
	@NotNull
	String teamName;
	
	@NotNull
	String taskDescription;

	public Work() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Work(long workId, @NotNull long employeeId, @NotNull String teamName, @NotNull String taskDescription) {
		super();
		this.workId = workId;
		this.employeeId = employeeId;
		this.teamName = teamName;
		this.taskDescription = taskDescription;
	}

	public long getWorkId() {
		return workId;
	}

	public void setWorkId(long workId) {
		this.workId = workId;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	@Override
	public String toString() {
		return "Work [workId=" + workId + ", employeeId=" + employeeId + ", teamName=" + teamName + ", taskDescription="
				+ taskDescription + "]";
	}
	
	
	
}
