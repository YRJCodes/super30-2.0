package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Student {
	// @NotBlank(message = "name cannot be blank")
	//@Email
	//@Pattern()
	@NotBlank(message = "Name cannot be blank")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must contain only letters and spaces")
	   private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/*
	 * ⚠️ What went wrong

You likely had this:

@Id
private Long id; // but no @GeneratedValue


Which means JPA expects you to set the ID manually (but you didn’t), hence the error.
	 */
	
	    @Min(value = 1, message = "Age must be at least 1")
	    @Max(value = 100, message = "Age must be at most 100")
	    int age;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

//		public Student(String name , int age,Long id){
//			this.id=id;
//			this.name = name;
//			this.age = age;
//		}
//
//		public Student() {
//			super();
//			// TODO Auto-generated constructor stub
//		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", id=" + id + ", age=" + age + "]";
		}

}
