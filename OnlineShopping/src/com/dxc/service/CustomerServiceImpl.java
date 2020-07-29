package com.dxc.service;

import java.util.List;

import com.dxc.dao.CustomerDaoImpl;
import com.dxc.pojos.Cart;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;

public class CustomerServiceImpl {
	
	CustomerDaoImpl dao = new CustomerDaoImpl();
	
	public boolean CustLogin(int customerid,String password)
	{
		
		System.out.println("test..service");
		return dao.CustLogin(customerid, password);		
	}
	
	public List<Product> getAllProducts()
	{
		return dao.getAllProducts();
	}
	
	public void AddToCart(int id, int productno , Cart cart) 
	{
	dao.AddToCart(id,productno,cart);	
	}
	
	public List<Cart> getCartList(int id, int productno)
	{
		return dao.getCartList(id, productno);
	}
	
	public boolean addBalancetowallet(int cid,double balance, Customer cust)
	{
		return dao.addBalancetoWallet(cid, balance, cust);
	}
	
	public boolean payBill(int id,int productno,double payAmount,int quantity)
	{
		return dao.payBill(id, productno, payAmount, quantity);
	}
	
	public List<Product> DisplayCartList(int id) 
	{
		return dao.DisplayCartList(id);
	}
	
	public double showBalance(int customerid)
	   {
		return dao.showBalance(customerid);	
		}
}
