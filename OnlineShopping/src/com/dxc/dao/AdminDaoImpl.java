package com.dxc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.dxc.pojos.Admin;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;

public class AdminDaoImpl
{
private static SessionFactory sessionFactory;
	
	static{
		Configuration configuration=new Configuration().configure();
		sessionFactory=configuration.buildSessionFactory();
	}
	
	public void addAdmin(Admin a)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(a);
		session.getTransaction().commit();
	}
		  public boolean checkLogin(int id,String password)
		  {
			  boolean b=false;
			  System.out.println("test...dao");
			  System.out.println(id+"    "+password);
			  Session session=sessionFactory.openSession();
			  Query query=session.createQuery("from Admin");
			  
			  List<Admin> list = query.getResultList();
			  System.out.println(list);
			  for(Admin l : list)
			  {
			  if((id==l.getId()) && (password.equals(l.getPassword())))
			  {
				 b=true;
				 break;
			  }
			  }
			return b;
			  
		  }
		  
		  public void addProduct ( Product p)
		  {
			  Session session=sessionFactory.openSession();
			  session.beginTransaction();
			  session.save(p);
			  session.getTransaction().commit();
			  
		  }
		  
		  public List<Product> getAllProducts()
		  {
			  Session session = sessionFactory.openSession();
			  Query query=session.createQuery("from Product");
			  return query.getResultList();
			  
		  }
		  
		  public void addCustomer(Customer c)
		  {
			  Session session=sessionFactory.openSession();
			  session.beginTransaction();
			  session.save(c);
			  session.getTransaction().commit();			  
		  }
		  
		  public boolean findcustomer(int customerid)
		  {
			  Customer c=null;
			  Session session=sessionFactory.openSession();
			  Query query=session.createQuery("from Customer where customerid=:customerid");
			  query.setParameter("customerid", customerid);
			  List<Customer> c1=query.getResultList();
			  try {
				  c=c1.get(0);
				  return true;
			  }
			  catch(Exception e)
			  {
				  return false;
			  }
		  }
		  public void removecustomer(int i)
		  {
			  Session session=sessionFactory.openSession();
			  session.beginTransaction();
			  Query query=session.createQuery("delete from Customer where customerid=:i");
			  query.setParameter("i", i);
			  query.executeUpdate();
			  session.getTransaction().commit();
		  }
		  
		  public List<Customer> getAllCustomers()
		  {
			  Session session=sessionFactory.openSession();
			  Query query=session.createQuery("from Customer");
			  return query.getResultList();
		  }
}