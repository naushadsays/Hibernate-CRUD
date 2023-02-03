package com.jsp.service;

import java.util.Scanner;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

public class StudentService {
	Scanner sc = new Scanner(System.in);
	Scanner sc1 = new Scanner(System.in);

	public Student create() {
		Student student = new Student();
		System.out.println("enter id");
		student.setId(sc.nextInt());
		System.out.println("enter name");
		student.setName(sc1.nextLine());
		System.out.println("enter email");
		student.setEmail(sc1.nextLine());

		StudentDao studentDao = new StudentDao();
		studentDao.create(student);
		System.out.println("All Good");
		return student;
	}

	public Student readById() {
		System.out.println("enter id to display the record");
		int id=sc.nextInt();
		StudentDao studentDao = new StudentDao();
		Student s1=studentDao.getStudentById(id);

		System.out.println(s1.getId());
		System.out.println(s1.getEmail());
		System.out.println(s1.getName());
		return s1;
	}
	public Student update() {
		System.out.println("enter id to update the record");
		int id=sc.nextInt();
		
		StudentDao studentDao = new StudentDao();
		Student s1=studentDao.updateStudent(id);
	
		System.out.println("All Good");

		return s1;
	}
	public Student delete() {
		System.out.println("enter id to delete the record");
		int id=sc.nextInt();
		
		StudentDao studentDao = new StudentDao();
		Student s1=studentDao.deleteStudent(id);
		
		System.out.println("All Good");

		return s1;
	}
}
