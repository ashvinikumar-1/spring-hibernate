package com.ashvini.jdvc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ashvini.jdvc.entity.Instructor;
import com.ashvini.jdvc.entity.InstructorDetails;

public class DeleteInsrtuctor {

	public static void main(String[] args) {
		// create SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// begin transaction
			session.beginTransaction();
			// retrieve instructor
			Instructor instructor = session.get(Instructor.class, "2");
			session.delete(instructor);
			// commit transaction
			session.getTransaction().commit();
		} finally {
			session.close();
		}

	}

}
