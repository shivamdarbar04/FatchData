package com.javatpoint;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData 
{

	public static void main(String[] args)
	{
	Configuration cfg = new Configuration();
	cfg.setProperty("hibernate.connection.url", System.getenv("jdbc:mysql://localhost:3306/myhiber"));
	  
	cfg.configure("com.cfg.xml");
	SessionFactory factory = cfg.buildSessionFactory();
        
//    Employee emp = new Employee();
//    emp.setId(126);
//    emp.setFirstName("Abhay");
//    emp.setLastName("Khati");
//    System.out.println("Successfully stored values" );
    
    Session s = factory.openSession();
    Transaction tx = s.beginTransaction();
    
    Employee employee = (Employee)s.load(Employee.class, 1245);
	System.out.println(employee.getFirstName());
	System.out.println(employee.getLastName());
    System.out.println(employee.getId());

	
    tx.commit();
    s.close();
    
    factory.close();


    
  
	}
}
