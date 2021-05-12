package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Domain.Student;
import com.example.demo.Services.StidentService;

@SpringBootApplication
public class PersonDataApi1Application implements CommandLineRunner{
//    @Autowired
//    private StidentService stidentService;
	public static void main(String[] args) {
		SpringApplication.run(PersonDataApi1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
	}

}
