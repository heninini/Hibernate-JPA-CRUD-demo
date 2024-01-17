package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
//			createMultipleStudent(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		int numRowsDeleted=studentDAO.deleteAll();
		System.out.println(numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=1;
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId=1;
		Student myStudent=studentDAO.findby(studentId);
		myStudent.setFirstName("Henos");
		studentDAO.update(myStudent);
		System.out.println(myStudent);
	}

	private void queryByLastName(StudentDAO studentDAO) {
		List<Student> theStudent=studentDAO.findName("lidya");

		for (Student tempstudent:theStudent){
		System.out.println(theStudent);}
	}

	private void queryForStudents(StudentDAO studentDAO) {
//		get the students
		List<Student> thestudents =studentDAO.findAll();
//		display students
		for(Student tempstudent:thestudents){
			System.out.println(tempstudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student
		Student tempStudent=new Student("hens","samuel","yo.com");
		studentDAO.save(tempStudent);
		int theId= tempStudent.getId();
		Student student=studentDAO.findby(theId);
		System.out.println(student);

	}


	//reading a student

	private void createMultipleStudent(StudentDAO studentDAO) {
		//create student
		Student student1=new Student("den","lidya","gmail@gmail.com");
		Student student2=new Student("he","lor","gosaml@gmall");
		//save the students
		studentDAO.save(student1);
		studentDAO.save(student2);

	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("creting student");
		Student tempStudent= new Student("henos","ghirmay","henos.ghirmay@gmail.com");
		System.out.println("save");
    	studentDAO.save(tempStudent);

		System.out.println(tempStudent.getId());
	}

}