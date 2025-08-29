package com.oms.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long employeeId;
	
	@Min(value=20,message="Employee age must be atleast 20")
	int age;
	
	@NotBlank(message = "Name cannot be blank")
	@Size(max = 25, message = "Name cannot exceed 25 characters")
	String name;
	
	@Email
	String email;
	
	@Pattern(regexp = "^\\d{10}$", message="Enter a valid phone number")
	String phone;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(long employeeId, int age, String name, String email, String phone) {
		super();
		this.employeeId = employeeId;
		this.age = age;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", age=" + age + ", name=" + name + ", email=" + email
				+ ", phone=" + phone + "]";
	}
	
	
}
