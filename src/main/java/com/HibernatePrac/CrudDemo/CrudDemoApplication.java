package com.HibernatePrac.CrudDemo;

import com.HibernatePrac.CrudDemo.dao.studentDao;
import com.HibernatePrac.CrudDemo.entity.student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(studentDao studentDao) {
		return runner->{
			//createstduent(studentDao); // creating object in database

			// readstudent(studentDao); // reading data from database

			queryforstudent(studentDao);

		};
	}

	private void queryforstudent(studentDao studentDao) {
		List<student> students = studentDao.findAll();
		for (student student : students) {
			System.out.println(student);
		}
	}

	private void readstudent(studentDao studentDao) {
		System.out.println("inserting student data...");
		student student = new student("ashutosh","singh","new@gmail.com");
		student student1 = new student("sheetal","singh","sheetal@gmail.com");
		studentDao.save(student);
		studentDao.save(student1);

		System.out.println("reading student data...");
		student one = studentDao.findById(student1.getId());
		System.out.println(one);

	}

	private void createstduent(studentDao studentDao) {
		// create the student object
		System.out.println("creating  student");
		student tempstudent = new student("ashutosh","singh","ash@gmail.com");


		// save the object
		System.out.println("saving student");
		studentDao.save(tempstudent);


		// display id of saved student
		System.out.println("saved student, Generated id: " + tempstudent.getId());

	}
}


// THIS FOLLOWING IS WHAT THAT MEANS OF THAT LAMBDA EXPRESSION THAT WE HAVE USED AS THIS
// COMMANDLINERUNNER IS AN INTERFACE AND IT HAS THE THIS RUNNFUNCTION THAT HAS TO BE OVERRIIDEN

//@Bean
//public CommandLineRunner commandLineRunner(String[] args) {
//
//	return new CommandLineRunner() {
//
//		@Override
//		public void run(String... args) {
//			System.out.println("Hello World");
//		}
//
//	};
//}