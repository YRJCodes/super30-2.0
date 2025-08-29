package com.oms.work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import java.util.List;

@RestController
public class WorkController {

	@Autowired
	workrepo workrepo;
	
	@PostMapping("/work")
	public String assign(@Valid @RequestBody Work w,BindingResult result) {
		if(result.hasErrors())return result.getAllErrors().toString();
		workrepo.save(w);
		return "Work assigned";
	}
	
	@GetMapping("/work/employee/{id}")
	public List getall(@PathVariable Long id) {
	
		return workrepo.findByEmployeeId(id);
	}
}
