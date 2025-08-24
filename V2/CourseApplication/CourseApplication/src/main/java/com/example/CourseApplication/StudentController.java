package com.example.CourseApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/all")
	public List showStudents() {
		String url = "http://localhost:8080/students/all";
		return restTemplate.getForObject(url, List.class);
	}
	
	@PostMapping("/add")
	 public String addStudent(@RequestParam String name,@RequestParam int age) {//order does not matters
		
		String url="http://localhost:8080/students/add?name="+name+"&age="+age;
		 return restTemplate.postForObject(url, url, String.class);
	 }
	
	@PutMapping("/updateName/{index}")
	public String updateStudentName(@PathVariable int index,@RequestParam String name) {
		String url ="http://localhost:8080/students/updateName/"+index+"?"+"name="+name;
		restTemplate.put(url, null);
		return "Done";
	}
	
	@DeleteMapping("/delete/{index}")
	 public String deleteStudent(@PathVariable int index) {
		String url="http://localhost:8080/students/delete/"+index;
		 restTemplate.delete(url);
		 return "Deleted Successfully";
	}
}
