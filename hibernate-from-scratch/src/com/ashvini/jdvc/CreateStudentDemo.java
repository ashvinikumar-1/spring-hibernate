package com.ashvini.jdvc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ashvini.jdvc.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// create SessionFactory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create student object
			Student student = new Student("john","snow","john@gmail.com");
			//begin transaction
			session.beginTransaction();
			//save the student object
			session.save(student);
			//commit transaction
			session.getTransaction().commit();
			
		}finally {
			session.close();
		}

	}

}
