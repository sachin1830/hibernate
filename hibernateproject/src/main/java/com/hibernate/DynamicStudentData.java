package com.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DynamicStudentData
{
	public static void main(String[] args) 
	{
		Configuration cfg=new Configuration();
		cfg.configure();
		
		SessionFactory factory=cfg.buildSessionFactory();
		
		Session session=factory.openSession();
		
		
		int i=0;
		
		Scanner sc=new Scanner(System.in);
		
		
		while(i<=1)
		{
			System.out.println("Do you want to enter data press 1");
			
			 i=sc.nextInt();
			 
			 System.out.println("Enter id");
			 
			 int id=sc.nextInt();
			 
			 System.out.println("enter name");
			 
			 String name=sc.next();
			 sc.next();
			 
			 System.out.println("Enter address");
			 
			 String address=sc.next();
			 sc.next();
			
			 System.out.println("Enter certificate name ");
			 
			 String cname=sc.next();
			 sc.next();
			 
			 System.out.println("Enter certificate duration");
			 
			 String duration=sc.next();
			 
			 Transaction tx=session.beginTransaction();
			 
			 Student st=new Student();
			 
			 st.setId(id);
			 st.setName(name);
			 st.setAddress(address);
			 st.setCertificate(new Certificate(cname,duration));
			
			 
			 session.save(st);
			 tx.commit();
		}
		
		session.close();
		factory.close();
		
	}

}
