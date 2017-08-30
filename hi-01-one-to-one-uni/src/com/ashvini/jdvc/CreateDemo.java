package com.ashvini.jdvc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ashvini.jdvc.entity.Instructor;
import com.ashvini.jdvc.entity.InstructorDetails;


public class CreateDemo {

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
			//create the objects
			Instructor instructor = new Instructor("jon","snow","jon@gmail.com");
			
			InstructorDetails instructorDetails = new InstructorDetails("http://jon/youtube","Denarese");
			//associate the objects 
			instructor.setInstructorDetails(instructorDetails);
			//begin transaction
			session.beginTransaction();
			// save
			session.save(instructor);
			//commit transaction
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
		}

	}

}
