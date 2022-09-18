package com.orm.hibernateproject;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.orm.hibernateproject.entities.Student;


public class App 
{
	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //create an IOC tob talk to the hibernate
        Configuration cfg=new Configuration();
        cfg.configure("configh.xml");
        SessionFactory factory=cfg.buildSessionFactory();
      //Checking if the session created
        System.out.println(factory);
        System.out.println(factory.isClosed());
        //create student record
        Student student=new Student();
        student.setId(12);
        student.setName("Arshith");
        student.setCity("Chennai");
        System.out.println(student);
      //let's start the session
        Session session=factory.openSession();
        
        //save the session to save the data
        session.save(student);
        Transaction tx = session.beginTransaction();
        //commit
        tx.commit();
             
        session.close();
    }
}