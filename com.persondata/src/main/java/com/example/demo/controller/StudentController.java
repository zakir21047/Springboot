package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Domain.Student;
import com.example.demo.Services.StidentService;


@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	private StidentService studentService;
	
	@GetMapping("/getStudents")
	public ResponseEntity<List<Student>> getAllStudents(@RequestParam(defaultValue = "0") Integer pageNo,@RequestParam(defaultValue = "2") Integer pageSize) {
		List<Student> list = studentService.getAllStudentDetails(pageNo, pageSize);
		 
        return new ResponseEntity<List<Student>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/create")
	public Student createTicket(@RequestBody Student student) {
		return studentService.createStudent(student);
	}

	@DeleteMapping("/student/{phoneNO}")
	public void deleteStudent(@PathVariable("phoneNo") Integer phoneNo) {
		studentService.deleteStudent(phoneNo);
	}

	@PutMapping("/student/{phoneNO} {Email}")
	public Student updateStudent(@PathVariable("phoneNo") Integer phoneNo, @PathVariable("Email") String email) {
		return studentService.updateStudent(phoneNo, email);

	}
}
