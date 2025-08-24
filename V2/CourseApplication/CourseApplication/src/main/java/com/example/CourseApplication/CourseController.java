package com.example.CourseApplication;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;


@RestController
@RequestMapping("/courses")
public class CourseController {
	Map<Integer,List<String>> coursesByStudent = new HashMap<>();
	
	@PostMapping("/assign")
	public String assignCourse(@RequestParam int studentId,@RequestParam String course) {
		coursesByStudent.computeIfAbsent(studentId, id -> new ArrayList<>()).add(course);
		return "Assigned course " + course + " to student"+studentId;
	}
	
	@GetMapping("/student/{id}")
	public List<String> getCourses(@PathVariable int id){
		return coursesByStudent.getOrDefault(id, Collections.emptyList());
	}
	
	@DeleteMapping("/student/{id}")
	public String removeCourse(@PathVariable int id,@RequestParam String course) {
		List<String> list = coursesByStudent.get(id);
		if(list != null && list.remove(course)) {
			return "removed " + course + " from student "+id;
		}
		return "Course not found" +id;
	}
}
