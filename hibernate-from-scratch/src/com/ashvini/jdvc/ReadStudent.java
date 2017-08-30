package com.ashvini.jdvc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.ashvini.jdvc.entity.Student;

public class ReadStudent {

	public static void main(String[] args) {
		// create SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// begin transaction
			session.beginTransaction();
			// create student object
			Student student = session.get(Student.class, 2);

			System.out.println(student.getId() + " " + student.getFirstName() + " " + student.getEmail());
			//retrieve all rows
			List<Student> allStudent = session.createQuery("from Student").getResultList();

			for(Student stu:allStudent) {
				System.out.println(stu.getId() + " " + stu.getFirstName() + " " + stu.getEmail());
			}

		} finally {
			session.close();
		}

	}

}
