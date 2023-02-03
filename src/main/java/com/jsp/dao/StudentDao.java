package com.jsp.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.dto.Student;

public class StudentDao {
	
	Scanner sc = new Scanner(System.in);
	public Student create(Student s1) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student = new Student();
		entityTransaction.begin();
		entityManager.persist(s1);
		entityTransaction.commit();
		return student;
	}
	public Student getStudentById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Student s1 = new Student();

		s1 = entityManager.find(Student.class,1);
		
		return s1;
	}
	public Student updateStudent(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student s1 = entityManager.find(Student.class, id);
		if (s1!=null) {
			System.out.println("enter name");
			s1.setName(sc.nextLine());
			System.out.println("enter email");
			s1.setEmail(sc.nextLine());
			entityTransaction.begin();
			entityManager.merge(s1);
			entityTransaction.commit();
		} else {
			System.out.println("entity not found for thee given id");
		}
		return s1;
	}
	public Student deleteStudent(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Student s1 = entityManager.find(Student.class, id);
		
		entityTransaction.begin();
		entityManager.remove(s1);
		entityTransaction.commit();
		return s1;

	}
	
	
	
}
