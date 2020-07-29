package com.dxc.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.pojos.Cart;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;
import com.dxc.service.CustomerServiceImpl;

@Controller
@RequestMapping("/views")
public class CustomerController {
	
	CustomerServiceImpl service = new CustomerServiceImpl();
	Customer customer = new Customer();
	String status="";
	Product product;
	
	int quantity;
	private int id = 0;
	int cid;
	
	@RequestMapping("/custlogin")
	public String checkLogin(@RequestParam int customerid,HttpSession session, @RequestParam String password, Model m )
	  {
		session.setAttribute("customerid", customerid);
		customer.setCustomerid(customerid);
		customer.setPassword(password);
		this.id = customerid;
		 System.out.println(id+" "+password);
	     boolean b= service.CustLogin(customerid, password);
		   if(b==true)
			   {
			   return "customermenu";
			   }
		   else
		   {
			   status="Invalid credentials.";
			   m.addAttribute("status", status);
			   return "message";
		   }
	  }
	@RequestMapping("/addBalance")
	public String addBalance(@RequestParam double balance,@ModelAttribute Customer cust, Model m,HttpSession session) 
	{
		int  cid=(int) session.getAttribute("customerid");
		System.out.println(cid);
		boolean b = service.addBalancetowallet( cid, balance, cust);
		if(b==true) {
			status="amount added";
			} 
		else {
				status="amount not added";
			}
		m.addAttribute("status",status);
		return "message";
		
	}
	
	@RequestMapping("/custlogout")
	public String logout()
	{
		return "home";
	}
	
	@RequestMapping("/AvailableProducts")
	public String getAllProducts(Model m)	
	{
		List<Product> list = service.getAllProducts();
		m.addAttribute("list",list);
		return "displayall";
	}
	
	@RequestMapping("/show")
	public String show(@ModelAttribute Product product)
	{
		this.product = product;
		return "quantity";
	}
	
	@RequestMapping("/quantity")
	public String quantity(@RequestParam int quantity,Model m)
	{
		if(quantity <= product.getQuantity()) {
			product.setQuantity(quantity);
			m.addAttribute("product", product);
			return "confirm";
		} else {
			status = "quantity Exceeded ";
			m.addAttribute("status",status);
			return "message";
		}
	}
	@RequestMapping("/addtocart")
	public String AddToCart(@RequestParam int productno,@ModelAttribute Cart cart, Model m)
	{	
		cart.setId(id);
		service.AddToCart(id,productno,cart);
		status = "Successfully product is added to Cart";
		m.addAttribute("status",status);
		return "message";		
	}
	
	@RequestMapping("/payBill")
	public String payBill(@RequestParam int productno , Model m)
	{
		
		List<Cart> list = service.getCartList(id, productno);
		for(Cart c:list) {
			m.addAttribute("c",c);
		}
		return "PayBill";
	}
	
	@RequestMapping("/paidBill")
	public String paidBill(@RequestParam int productno,@RequestParam double payAmount,@RequestParam int quantity , Model m)
	{
		boolean b = service.payBill(id, productno, payAmount, quantity);
		if (b == true) {
			status = "Successfully Paid Amount";
		} else {
			status= "You Don't Have Enough Money";
		}
		m.addAttribute("status", status);
		return "message";
	}
	@RequestMapping("/CartProducts")
	public String DisplayCartList(Model m)
	{
		List<Product> list=service.DisplayCartList(id);
		m.addAttribute("list", list);
		return "checkcart";
	}
	
	@RequestMapping("/showbalance")
	public String showBalance(@RequestParam int customerid, Model m)
	{
		double amount=service.showBalance(customerid);
		status = "balance is=Rs"+amount;
		m.addAttribute("status",status);
		return "message";				
	}
}
