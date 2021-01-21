package com.hqlpagnation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.Student;

public class HqlPagenationExmpl
{
	public static void main(String[] args) 
	{
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory factory =cfg.buildSessionFactory();
		Session session=factory.openSession();
		
		String query ="from Student";
		
		Query fquery=session.createQuery(query);
		
		fquery.setFirstResult(2);
		
		fquery.setMaxResults(5);
		
		
		List<Student> list =fquery.list();
		
		for(Student std:list)
		{
			System.out.println(std.getName() +"  "+ std.getId());
		}
		
		
		
		
		
		
		session.close();
		factory.close();
		
		
	}

}
