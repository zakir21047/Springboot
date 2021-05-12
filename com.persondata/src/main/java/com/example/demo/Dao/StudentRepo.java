package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Domain.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
	
}
