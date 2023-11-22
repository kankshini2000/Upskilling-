package com.example.student.service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepo;

@Service
public class StudentService {

	
	Logger logger = LoggerFactory.getLogger(StudentService.class);
	@Autowired 
	private StudentRepo repo;
	
	public Student createStd(Student std) {
		logger.info("This method was invoked to create Std ");
		std.setId(UUID.randomUUID().toString().split("-")[0]);
		return repo.save(std);
	}
	
	public List<Student> getStd() {
		logger.info("This method was invoked to get list of created Std ");
		return repo.findAll();
	}
	
	public Student getByStdId(String id) {
		logger.info("This method was invoked to get list of Stds by its ID ");
		return repo.findById(id).get();
	}
	
	
	public Student getByName(String name) {
		logger.info("This method was invoked to get list of Std by its name");
		return repo.findByName(name);
	} 
	
	public Student updateStd(Student stdReq) {
		logger.info("This method was invoked to update Std info ");
		Student UpdatedStd=repo.findById(stdReq.getId()).get();
		UpdatedStd.setAge(stdReq.getAge());
		UpdatedStd.setName(stdReq.getName());
		UpdatedStd.setSalary(stdReq.getSalary());
		return repo.save(UpdatedStd);
	}
	
	public String DeleteStd(String id) {
		logger.info("This method was invoked to delete Std ");
		repo.deleteById(id);
		return "Student with" + id +"has been deleted ";
	}
	
}
