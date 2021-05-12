package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.StudentRepo;
import com.example.demo.Domain.Student;

@Service
public class StidentService {
	@Autowired
	private StudentRepo studentRepo;
	public Student createStudent(Student student) {
		return studentRepo.save(student);
	}
	public List<Student> getAllStudentDetails(Integer pageNo, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Student> list = studentRepo.findAll(pageable);
		if(list.hasContent()) {
			return list.getContent();
		}
		else {
			return new ArrayList<Student>();
		}
	}
	public Optional<Student> getStudent(Integer phoneNo) {
		return studentRepo.findById(phoneNo);
	}
	
	public void deleteStudent(Integer phoneNo) {
		studentRepo.deleteById(phoneNo);
	}
	
	public Student updateStudent (Integer PhoneNo,String email) {
		Student  student=studentRepo.findById(PhoneNo).orElse(new Student());
		student.setEmail(email);
		return studentRepo.save(student);

}
}
