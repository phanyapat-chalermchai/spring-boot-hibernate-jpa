package com.phanyapat.crudProject;

import com.phanyapat.crudProject.dao.StudentDAO;
import com.phanyapat.crudProject.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner -> {
//			createStudent(studentDAO);

//			readStudent(studentDAO);

//			queryAllStudent(studentDAO);

			queryStudentByLastName(studentDAO);
		};
	}

	private void queryStudentByLastName(StudentDAO studentDAO) {

		//get a list of students
		List<Student> studentList = studentDAO.findByLastName("Shaco");

		//display list of students
		studentList.forEach(System.out::println);
	}

	private void queryAllStudent(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findAll();
		studentList.forEach(System.out::println);
	}

	private void readStudent(StudentDAO studentDAO) {
		//create student
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Shatrix","Shaco","ohana@hotmail.com");

		//save student
		System.out.println("Saving student object ...");
		studentDAO.save(tempStudent);

		//display student id
		System.out.println("Saved student id : " + tempStudent.getId());

		//retrieve student based on the id: primary key
		Student tempStudentById = studentDAO.findById(tempStudent.getId());

		//display student
		System.out.println("Found student : " + tempStudentById.getId());
		System.out.println("Found student : " + tempStudentById);
	}

	private void createStudent(StudentDAO studentDAO) {
		//create student
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Ohana","Uwu","ohana@hotmail.com");

		//save student
		System.out.println("Saving student object ...");
		studentDAO.save(tempStudent);

		//display student id
		System.out.println("Saved student id : " + tempStudent.getId());
	}
}
