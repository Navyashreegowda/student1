package com.hcl.usecase.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.usecase.entity.Student;
import com.hcl.usecase.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;

	@PostMapping("/create")
	public String createStudent(@RequestBody Student student) {
		studentService.createStudent(student);
		return "ok";
	}

	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}

	@DeleteMapping("/delete")
	public void deleteStudent(int id) {
		studentService.deleteStudent(id);

	}

	@GetMapping("/getall")
	public List<Student> getAllStudent() {
		return studentService.getAllStudent();
	}

	@GetMapping("/get/{id}")
	public Optional<Student> getById(int id) {
		return studentService.getById(id);
	}

}
