package com.dxc.service;

import java.util.List;

import com.dxc.dao.AdminDaoImpl;
import com.dxc.pojos.Admin;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;

public class AdminServiceImpl  {
	
	AdminDaoImpl dao=new AdminDaoImpl();
	
	
	public void addAdmin(Admin a)
	{
		dao.addAdmin(a);
	}

	public boolean checkLogin(int id,String password)
	{
		
		System.out.println(id+" "+password);
		return dao.checkLogin(id, password);
		
	}
	
	public void addProduct(Product p)
	{
		dao.addProduct(p);
	}
	
	public List<Product> getAllProducts()
	{
		return dao.getAllProducts();
	}
	
	public void addCustomer(Customer c)
	{
		dao.addCustomer(c);
	}
	
	public boolean findcustomer(int customerid) {
		
		return dao.findcustomer(customerid);
	}

	public void removecustomer(int i) 
	{
		dao.removecustomer(i);	
	}

	public List<Customer> getAllCustomers() 
	{
	 return dao.getAllCustomers();
	}
	
	
}
