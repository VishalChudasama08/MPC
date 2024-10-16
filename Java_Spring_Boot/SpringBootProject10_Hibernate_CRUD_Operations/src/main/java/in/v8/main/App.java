package in.v8.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.v8.entities.User;

public class App {
    public static void main( String[] args ) {
        Configuration cfg = new Configuration();
        cfg.configure("in/v8/config/hibernate.cfg.xml");
        
        // SessionFactory creates and manages Session objects; note crate this class object many time 
        // it is a heavy weight, thread-safe object used to configure Hibernate and handle connections.
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        
        // Session manages database operations like CRUD wand querying; 
        // it is a light weight, short-lived object for interacting with the database.
        Session session = sessionFactory.openSession();
        
        // Transaction controls the boundaries of a database transaction; 
        // it is used to begin, commit, or roll back changes to ensure data integrity. 
        Transaction transaction = session.beginTransaction();
        
        // ------------------ Insert ----------------------------------------------
//      // User user = new User("Vishal", "vishal@gmail.com", "male", "rajkot");
//        User user = new User("Bhavesh", "bhavesh@gmail.com", "male", "kotadiya");
        
//      try {
//        	session.save(user); // insert in to data base 
//            transaction.commit();
//            System.out.println("User Details Added successfully");
//		} catch (Exception e) {
//			transaction.rollback();
//			e.printStackTrace();
//			System.out.println("User Details Not Added Deu to Same Error");
//		}
        
        // ------------------ Update ----------------------------------------------
//        try {
//        	User user = session.get(User.class, 2l); // get row which you can update
//        	user.setCity("Kotadiya"); // update 
//        	
//        	session.saveOrUpdate(user); // insert 
//            transaction.commit();
//            System.out.println("User Details Updated successfully");
//		} catch (Exception e) {
//			transaction.rollback();
//			e.printStackTrace();
//			System.out.println("User Details Not Updated Deu to Same Error");
//		}
        
        // ------------------ Delete ----------------------------------------------
//        try {
//        	User user = new User();
//        	user.setId(2l); // set id only which you can delete
//        	
//        	session.delete(user); 
//            transaction.commit();
//            System.out.println("User Details Deleted successfully");
//		} catch (Exception e) {
//			transaction.rollback();
//			e.printStackTrace();
//			System.out.println("User Details Not Deleted Deu to Same Error");
//		}
        
        // ------------------ Select / get one row ---------------------------------
//        try {
//        	User user = session.get(User.class, 3l); // get data 2nd:- id 
//        	if (user != null) {
//        		user.displayUser();
//        	} else {
//        		System.out.println("User Not Found");
//        	}
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("User Details Not Get Deu to Same Error");
//		}
        
        // ------------------ Select / get all row --------------------------------
        try {
        	List<User> users = session.createQuery("from User", User.class).list();
        	for (User user : users) {
        		user.displayUser();
        	}
        } catch (Exception e) {
        	e.printStackTrace();
        	System.out.println("User Details Not Get Deu to Same Error");
        }
        
    }
}
