package com.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.Student;

public class HqlExamp {

	public static void main(String[] args) 
	{
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory factory=cfg.buildSessionFactory();
		
		Session session =factory.openSession();
		
		
		//HQL syntax
		
		// here x is the dynamic variable  
		String query="from Student where address=:x";
		
		Query q= session.createQuery(query);	
		
		q.setParameter("x", "USA");
		//here we are returning list of data 
		
		List<Student> list=q.list();
		
		for(Student s:list)
		{
			System.out.println(s.getName());
		}
		
		System.out.println("...................................................");
		
		//Here we are deleting data from the database
		
		Transaction tx=session.beginTransaction();
		
		String query1="delete from Student where address=:ad";
		
		Query q1=session.createQuery(query1);
		
		q1.setParameter("ad", "USA");
		
		int nd=q1.executeUpdate();
		System.out.println(nd);
		
		tx.commit();
		
		
		factory.close();
		
	}

}
