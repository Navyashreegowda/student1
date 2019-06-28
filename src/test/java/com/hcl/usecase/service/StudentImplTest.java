package com.hcl.usecase.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.usecase.entity.Student;
import com.hcl.usecase.repository.StudentRepo;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
public class StudentImplTest {

	@InjectMocks
	StudentImpl studentImplMock;

	@Mock
	StudentRepo studentRepo;

	Student studentOriginal = new Student();

	@Test
	public void createStudentTest() {
		studentOriginal.setAge(24);
		studentOriginal.setEmail("a@acom");
		studentOriginal.setMoblie(3456789);
		studentOriginal.setName("shashank");

		when(studentRepo.save(Mockito.any())).thenReturn(studentOriginal);
		Student studentExpect = studentImplMock.createStudent(studentOriginal);
		Assert.assertEquals(studentOriginal, studentExpect);
	}

	@Test
	public void deleteStudentTest() {
		doNothing().when(studentRepo).deleteById(Mockito.anyInt());
		studentImplMock.deleteStudent(1);
	}
 
}
