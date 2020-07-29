package com.dxc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.dxc.pojos.Admin;
import com.dxc.pojos.Cart;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;

public class CustomerDaoImpl {
	
private static SessionFactory sessionFactory;
	
	static{
		Configuration configuration=new Configuration().configure();
		sessionFactory=configuration.buildSessionFactory();
	}
		
	public boolean CustLogin(int customerid,String password)
	  {
		boolean b=false;
		  System.out.println("test...dao");
		  System.out.println(customerid+"    "+password);
		  Session session=sessionFactory.openSession();
		  Query query=session.createQuery("from Customer");
		  
		  List<Customer> list = query.getResultList();
		  System.out.println(list);
		  for(Customer l : list)
		  {
		  if((customerid==l.getCustomerid()) && (password.equals(l.getPassword())))
		  {
			 b=true;
			 break;
		  }
		  }
		return b;		  
	  }
	
	
	public List<Product> getAllProducts()
	{
		Session session = sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		return query.getResultList();
	}
	
	public boolean addBalancetoWallet(int cid , double balance, Customer cust)
	{
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
				
		Query query= session.createQuery("from Customer where customerid=:customerid");
	query.setParameter("customerid", cid);
	//double custbal=c.getBalance();
	
	double bal=0;
	List<Customer> list = query.getResultList();
	for (Customer c1 : list) {
		bal=c1.getBalance()+balance;
         System.out.println(bal);
		Query query1= session.createQuery("update Customer set balance=:bal where customerid=:customerid ");
		System.out.println("hello");
		query1.setParameter("customerid", cid);
		query1.setParameter("bal", bal);
		query1.executeUpdate();
		
	}
	session.getTransaction().commit();
	return true;
	}
	public void AddToCart(int id, int productno, Cart cart) 
	{
		
		cart.setId(id);
		cart.setProductno(productno);
		Session session=sessionFactory.openSession();
		session.beginTransaction();
	
		session.save(cart);
		session.getTransaction().commit();			
	}
	
	public List<Cart> getCartList(int id, int productno){
		
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Cart where id=:id AND productno=:productno");
		query.setParameter("id", id);
		query.setParameter("productno", productno);
		return query.getResultList();
	}
	
	public boolean payBill(int id, int productno, double payAmount, int quantity) {
		Cart cart = new Cart();
		Product product = new Product();
		Customer cust = new Customer();

		int quan ;
		double bal = 0;

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Product where productno=:productno");
		query.setParameter("productno", productno);
		
		List<Product> list = query.getResultList();
		for(Product p:list) {
			quan = p.getQuantity() - quantity;
			Query query1 = session.createQuery("update Product set quantity=:quantity where productno=:productno");
			query1.setParameter("productno", productno);
			query1.setParameter("quantity", quan);
			query1.executeUpdate();
		}
		session.getTransaction().commit();

		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		Query query2 = session2.createQuery("from Customer where customerid=:customerid");
		query2.setParameter("customerid", id);
		List<Customer> list1 = query2.getResultList();

		for(Customer c : list1) {
			bal = c.getBalance() - payAmount;
			if (c.getBalance() >= payAmount) {
				Query query3 = session2.createQuery("update Customer set balance=:bal where customerid=:customerid");
				query3.setParameter("customerid", id);
				query3.setParameter("bal", bal);
				query3.executeUpdate();
			} else {
				return false;
			}
		}
		session2.getTransaction().commit();

		Session session3 = sessionFactory.openSession();
		session3.beginTransaction();
		Query query4 = session3.createQuery("delete from Cart where id=:id AND productno=:productno");
		query4.setParameter("id", id);
		query4.setParameter("productno", productno);
		query4.executeUpdate();
		session3.getTransaction().commit();
		return true;
	}
	
	public List<Product> DisplayCartList(int id) 
	{
		List<Product> list=new ArrayList<Product>();
		
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Cart");
		List<Cart> clist=query.getResultList();
		for(Cart cart:clist)
		{
		  if(id==cart.getId())	
		  {
			  int productno=cart.getProductno();
			  Query query1=session.createQuery("from Product where productno=:productno");
			  query1.setParameter("productno", productno);
			  List<Product> list3=query1.getResultList();
			  for(Product product : list3)
			  {
				  list.add(product);
			  }
		  }
		}
		return list;
	}
	
	public double showBalance(int customerid) {
		double amount=0.0;
		Customer c=null;
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Customer where customerid=:customerid");
		query.setParameter("customerid", customerid);
		List<Customer> clist=query.getResultList();
		c=clist.get(0) ;
		amount=c.getBalance();
		session.close();
	
		return amount;
		}
	
	
}
