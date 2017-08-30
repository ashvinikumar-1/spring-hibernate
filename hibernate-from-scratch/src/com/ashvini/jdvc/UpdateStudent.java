package com.ashvini.jdvc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ashvini.jdvc.entity.Student;

public class UpdateStudent {
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
			student.setEmail("johnsnow@got.com");
			// commit transaction
			session.getTransaction().commit();
			// new Session
			session = factory.getCurrentSession();
			// begin transaction
			session.beginTransaction();
			session.createQuery("Update Student s set email='john@got.com' where id=2").executeUpdate();
			// commit transaction
						session.getTransaction().commit();

		} finally {
			session.close();
		}

	}
}
