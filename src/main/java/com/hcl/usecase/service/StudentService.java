package com.hcl.usecase.service;

import java.util.List;
import java.util.Optional;

import com.hcl.usecase.entity.Student;

public interface StudentService {
	
	public Student createStudent(Student student);
	public Student updateStudent(Student student);
	public void deleteStudent(int id);
	public List<Student> getAllStudent();
	public Optional<Student> getById(int id);

}
