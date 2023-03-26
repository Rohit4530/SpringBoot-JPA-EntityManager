package com.crud;

import com.crud.dao.StudentDAO;
import com.crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication  {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);

	}
      @Bean
	public CommandLineRunner  commandLineRunner(StudentDAO StudentDAO){
		return  runner->{
			createStudent(StudentDAO);

			//readAllStudent(StudentDAO);
			//updateStudent(StudentDAO);
			deleteStudent(StudentDAO);
		};
	  }

	private void deleteStudent(StudentDAO studentDAO) {
		System.out.println(studentDAO.findById(1));
		studentDAO.deleteStudent(1);
		System.out.println(studentDAO.findById(1));
	}

	private void updateStudent(StudentDAO studentDAO) {

		Student temp=new Student("rohit","gunjal","rg@gamil.com");
		studentDAO.save(temp);
		System.out.println(studentDAO.findById(temp.getId()));
		temp.setFirstName("kk");
		studentDAO.update(temp);
		System.out.println(studentDAO.findById(temp.getId()));
	}

	private void readAllStudent(StudentDAO studentDAO) {
		List<Student> list=studentDAO.findAll();
		for(Student student:list){
			System.out.println(student);
		}
	}

	private void createStudent(StudentDAO studentDAO) {
		Student temp=new Student("rohit","gunjal","rg@gamil.com");
		studentDAO.save(temp);
		System.out.println(temp.getId());
	}
	private  void readStudent(StudentDAO studentDAO){
		Student temp=new Student("rohit","gunjal","rg@gamil.com");
		studentDAO.save(temp);
		System.out.println(studentDAO.findById(temp.getId()));
	}

}
