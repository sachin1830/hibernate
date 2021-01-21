package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernetObjState {

	public static void main(String[] args) 
	{
		
		Configuration cfg=new Configuration();
		cfg.configure();
		
		SessionFactory factory=cfg.buildSessionFactory();
		
		//creating student object
		
		//this is present in the transient state
		
		Student std=new Student();
		std.setId(1122);
		std.setName("Henry kilton");
		
		std.setAddress("USA");
		std.setCertificate(new Certificate("python","3mounth"));
		
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		//now the student object present in the persistent state
		session.save(std);
		
		//std.setAddress("Germanny");
		
		tx.commit();
		factory.close();
		
		
	}

}
