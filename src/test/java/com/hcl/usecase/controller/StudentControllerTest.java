package com.hcl.usecase.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.usecase.entity.Student;
import com.hcl.usecase.service.StudentImpl;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {TestContext.class, StudentController.class})
@WebAppConfiguration
public class StudentControllerTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	StudentController studentController;
	
	@Mock
	StudentImpl studentImpl;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
	}
	
	@Test
	public void testCreateStudent() throws JsonProcessingException, Exception {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		Student student = new Student(10, "Abhi", "abhi@hcl.com", 908822, 12);
		Mockito.when(studentImpl.createStudent(Mockito.anyObject())).thenReturn(student);
		this.mockMvc.perform(post("/student/create").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(student))).andReturn();
		String actualMessage = studentController.createStudent(student);
		assertEquals("ok", actualMessage);
	}
}