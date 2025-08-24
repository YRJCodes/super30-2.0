package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.converters.Auto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {
 List<Student> students = new ArrayList<>();
 
 @Autowired
 RestTemplate restTemplate;
 
 @Autowired
 StudentRepo studentrepo;
 @PostMapping("/add")
 public ResponseEntity<?> addStudent(@Valid @RequestBody Student student, BindingResult result) {
     if (result.hasErrors()) {
         
         String errors = result.getAllErrors()
                               .stream()
                               .map(err -> err.getDefaultMessage())
                               .collect(Collectors.joining(", "));
         return ResponseEntity.badRequest().body("Validation errors: " + errors);
     }

     studentrepo.save(student);
     return ResponseEntity.ok("Student added: " + student.getName());
 }
// @PostMapping("/add")
// public String addStudent(@RequestBody Student student) {//order does not matters
//	
//	 students.add(student);
//	 return "Student added: "+student.getName();
// }
 
// @PostMapping("/add")
// public ResponseEntity<String> addStudent(@Valid @RequestBody Student student, BindingResult result) {
//     if (result.hasErrors()) {
//         
//         String errors = result.getAllErrors()
//                               .stream()
//                               .map(err -> err.getDefaultMessage())
//                               .collect(Collectors.joining(", "));
//         return ResponseEntity.badRequest().body("Validation errors: " + errors);
//     }
//
//     students.add(student);
//     return ResponseEntity.ok("Student added: " + student.getName());
// }
 
 

 
 @GetMapping("/all")
 public ResponseEntity<List<Student>> getAllStudents() {
//	 if(students.isEmpty()) {
//		 //return ResponseEntity.noContent().build();
//		 //return ResponseEntity.status(403).build();
//		 //return ResponseEntity.badRequest().body(students);
//		 
//	 }
	 //return ResponseEntity.ok(students);
	 return ResponseEntity.ok(studentrepo.findAll());
	 //return ResponseEntity.status(777).body(students);
	 //return ResponseEntity.status(HttpStatus.SC_REQUEST_TOO_LONG).body(students);
	 //return ResponseEntity.badRequest().body(students);
 }
// 
// @PutMapping("/updateName/{index}")
// public String updateStudentName(@PathVariable int index,@RequestParam String name) {
//	 if(index >= 0 || index<students.size()) {
//		 Student s= new Student(students.get(index).getName(),students.get(index).getAge());
//		 s.setName(name);
//		 students.set(index,s );
//		 return "Student updated at index" + index + " : " + name;
//	 }
//	 else {
//		 return "invalid index";
//	 }
// }
// @PutMapping("/updateAge/{index}")
// public String updateStudentAge(@PathVariable int index,@RequestParam int age) {
//	 if(index >= 0 || index<students.size()) {
//		 Student s= new Student(students.get(index).getName(),students.get(index).getAge());
//		 s.setAge(age);
//		 students.set(index,s );
//		 return "Student updated at index" + index + " : " + age;
//	 }
//	 else {
//		 return "invalid index";
//	 }
// }

 
 @DeleteMapping("/delete/{index}")
 public String deleteStudent(@PathVariable int index) {
	 students.remove(index);
	 
	 return "Student "+index +" deleted";
 }
 
 @GetMapping("{index}/courseDisplay")
 public List<String> getCourseForStudent(@PathVariable int index){
	 String url = "http://CourseApplication/courses/student/"+index;
	 return restTemplate.getForObject(url, List.class);
 }
 	@PostMapping("{index}/course")
 	public String assignCourseToStudent(@PathVariable int index,String course) {
 		String url =  "http://CourseApplication/courses/assign?course="+course+"&"+"studentId="+index;
 		return restTemplate.postForObject(url, null, String.class);
 	}
 
}
