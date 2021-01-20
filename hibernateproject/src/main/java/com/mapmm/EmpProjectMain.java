package com.mapmm;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmpProjectMain {

	public static void main(String[] args) 
	{
		
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Session session =factory.openSession();
		
		Project pro1=new Project();
		Project pro2=new Project();
		
		Employee emp1=new Employee();
		Employee emp2=new Employee();
		
		
		pro1.setProId(101);
		pro1.setProName("Collage Management");
		pro2.setProId(102);
		pro2.setProName("Librery Management");
		
		emp1.setEmpId(111);
		emp1.setEmpName("Ram");
		emp2.setEmpId(222);
		emp2.setEmpName("Shyam");
		
		List<Employee> emps= new ArrayList<Employee>();
		emps.add(emp1);
		emps.add(emp2);
		
		List<Project> pros=new ArrayList<Project>();
		pros.add(pro1);
		pros.add(pro2);
		
		pro1.setEmployees(emps);
		pro2.setEmployees(emps);
		
		emp1.setProjects(pros);
		emp2.setProjects(pros);
		
		Transaction tx=session.beginTransaction();
		
		session.save(emp1);
		session.save(emp2);
		session.save(pro1);
		session.save(pro2);
		
		
		tx.commit();
		
		
		
		session.close();
		factory.close();
	}

}