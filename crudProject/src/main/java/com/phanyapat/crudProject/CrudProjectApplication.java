package com.phanyapat.crudProject;

import com.phanyapat.crudProject.dao.StudentDAO;
import com.phanyapat.crudProject.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		//create student
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Cristenal","Ronaldo","cris.r@hotmail.com");

		//save student
		System.out.println("Saving student object ...");
		studentDAO.save(tempStudent);

		//display student id
		System.out.println("Saved student id : " + tempStudent.getId());

	}
}
