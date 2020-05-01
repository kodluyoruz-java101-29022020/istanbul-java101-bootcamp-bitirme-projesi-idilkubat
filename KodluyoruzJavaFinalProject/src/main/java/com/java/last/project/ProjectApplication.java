package com.java.last.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.java.last.project.model.Book;

@SpringBootApplication // SpringBoot projesi olduğunu belirttik
public class ProjectApplication {

	// @MethodRunningTime(active = false)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(ProjectApplication.class, args);
	}
}
