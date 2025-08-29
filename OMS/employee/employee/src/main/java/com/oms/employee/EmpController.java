package com.oms.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
@RestController
public class EmpController {

	@Autowired
	EmpRepo emprepo;
	
	@PostMapping("/create")
	public String create(@Valid   @RequestBody Employee e,BindingResult result) {
if(result.hasErrors()) {
	return result.getAllErrors().toString();
}
		emprepo.save(e);
		return "Employee : "+e.getName()+" added";
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<?> all(){
		return ResponseEntity.ok(emprepo.findAll());
	}
	
	//getbyid,put(update by id
//	delete
	
	@GetMapping("/employee{id}")
 public ResponseEntity<?>byid(@Valid @PathVariable Long id,BindingResult result){
		if(result.hasErrors()) {
			return ResponseEntity.status(619).body("please enter valid index");
		}
		return ResponseEntity.ok(emprepo.findById(id));
		
	}
	@PutMapping("/update{index}")
	public String update(@Valid @PathVariable Long id,BindingResult result,@RequestBody Employee e) {
		if(result.hasErrors()) {
			return "Please enter valid id";
		}
		Employee e2= emprepo.getById(id);
		e2.setAge(e.getAge());
		e2.setEmail(e.getEmail());
		e2.setName(e.getName());
		e2.setPhone(e.getPhone());
		return "Updated successfully";
	}
	
	@DeleteMapping("/delete{id}")
	public String delete(@Valid @PathVariable Long id,BindingResult result) {
		if(result.hasErrors()) {
			return "Please enter valid id";
		}
		emprepo.deleteById(id);
		return "Deleted successfully";
	}
}
