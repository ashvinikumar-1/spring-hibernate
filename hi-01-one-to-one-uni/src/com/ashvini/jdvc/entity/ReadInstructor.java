package com.ashvini.jdvc.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ReadInstructor {

	public static void main(String[] args) {
		// create SessionFactory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// begin transaction
			session.beginTransaction();
			// retrieve all rows
			List<Instructor> allInstructor = session.createQuery("from Instructor").getResultList();

			for (Instructor stu : allInstructor) {
				System.out.println(stu);
			}

		} finally {
			session.close();
		}

	}

}
