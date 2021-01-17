package com.hibernate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        
        
        //we can write this way also 
        
//         Configuration cg=new Configuration();
//         
//         cg.configure();
//         
//         SessionFactory fact=cg.buildSessionFactory();
        
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
        
        //here we are creating the object of student
//        Student student=new Student();
//        student.setId(111);
//        student.setName("Sachin kumar Biswal");
//        student.setAddress("BBSr");
        
        //here we are creating the object of Address
        Address ad=new Address();
        ad.setCity("BBSR");
        ad.setStreet("Dumuduma");
        ad.setX("3.888");
        ad.setIsOpen(true);
        ad.setAddedDate(new Date());
        
        //saving the image to database
        
        FileInputStream fi=new FileInputStream("src/main/java/pic.jpg");
        byte[] data= new byte[fi.available()];
        
        fi.read(data);
        ad.setImage(data);
        
        //the openSession() open a new session        
        Session session= factory.openSession();
        
        Transaction tx=session.beginTransaction();
        
        //session.save(student);
        session.save(ad);

        tx.commit();
        
        session.close();
    }
}
