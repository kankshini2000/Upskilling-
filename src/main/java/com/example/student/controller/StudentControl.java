package com.example.student.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.model.Student;
import com.example.student.service.StudentService;

@RestController
@RequestMapping("/api/std")
public class StudentControl {
	
	Logger logger = LoggerFactory.getLogger(StudentControl.class);
	@Autowired
	private StudentService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public Student createStd(@RequestBody Student std) {
		logger.info("This method was invoked to createStd");
		return service.createStd(std);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Student> getStudent() {
		logger.info("This method was invoked to getStudent");
		return service.getStd();
	}
	
	@GetMapping("/{id}")
	public Student findStdId(@PathVariable String id) {
		logger.info("This method was invoked to find Std by its id");
		return service.getByStdId(id);
	}
	
	
	
	@GetMapping("/name/{name}")
	public Student findStdName(@PathVariable String name) {
		logger.info("This method was invoked to find Std by its name");
		return service.getByName(name);
	} 
	
	@PutMapping
	public Student modifyStd(@RequestBody Student std) {
		logger.info("This method was invoked to modify std info");
		return service.updateStd(std);
	}
	
	@DeleteMapping("/del/{id}")
	public String DeleteStd(@PathVariable String id) {
		logger.info("This method was invoked to delete std by id");
		return service.DeleteStd(id);
	}
	

}
