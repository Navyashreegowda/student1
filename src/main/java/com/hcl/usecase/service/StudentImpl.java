package com.hcl.usecase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.usecase.entity.Student;
import com.hcl.usecase.repository.StudentRepo;
@Service
public class StudentImpl implements StudentService {
	@Autowired
	StudentRepo studentRepo;

	@Override
	public Student createStudent(Student student) {
		 studentRepo.save(student);
		 return student;
	}

	@Override
	public Student updateStudent(Student student) {
		
		return studentRepo.save(student);
	}

	@Override
	public void deleteStudent(int id) {
		studentRepo.deleteById(id);

	}

	@Override
	public List<Student> getAllStudent() {
		
		return studentRepo.findAll();
	}

	@Override
	public Optional<Student> getById(int id) {
	
		return studentRepo.findById(id);
	}

}
