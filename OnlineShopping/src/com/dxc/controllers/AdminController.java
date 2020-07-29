package com.dxc.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.pojos.Admin;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;
import com.dxc.service.AdminServiceImpl;


@Controller
@RequestMapping("/views")
public class AdminController {
		
		AdminServiceImpl service=new AdminServiceImpl();
		
		String status =" ";
				
		@RequestMapping("/add")
		public String addAdmin(@ModelAttribute Admin a, Model m)
		{
			System.out.println(a.getId()+" "+a.getPassword());
			service.addAdmin(a);
			status="Admin added successfully";
			m.addAttribute("status", status);
			return "message";
		}
				
		@RequestMapping("/login")
		public String checkLogin(@RequestParam int id, @RequestParam String password, Model m )
		  {
			  System.out.println(id+" "+password);
		     boolean b= service.checkLogin(id, password);
			   if(b==true)
				   {
				   return "adminmenu";
				   }
			   else
			   {
				   status="Invalid credentials.";
				   m.addAttribute("status", status);
				   return "message";
			   }
		  }
		
		@RequestMapping("/addproduct")
		public String addproduct(@ModelAttribute Product p, Model m)
		  {
			service.addProduct(p);
			status="products added";
			m.addAttribute("status", status);
			return "message";
		  }
		
		@RequestMapping("/AllProducts")
		public String getAllProducts(Model m)
		{
			List<Product> list=service.getAllProducts();
			m.addAttribute("list",list);
			return "AllProducts";
		}
		
		@RequestMapping("/addcustomer")
		public String addcustomer(@ModelAttribute Customer c,Model m)
		{
			service.addCustomer(c);
			status="customer added succesfully";
			m.addAttribute("status",status);
			return "message";
		}
		
		@RequestMapping("/findcustomer")
		public String find(@RequestParam("customerid") int customerid, Model m, HttpSession session)
		{
			boolean status=true;
			
			session.setAttribute("customerid", customerid);
			
			status=service.findcustomer(customerid);
			String msg;
						
			if(status==true)
			{
				return "removecustomer";
				
			}
			else 
			{
				msg="customer not found !";
				m.addAttribute("msg", msg);
				return "customernotfound";
			}
		}
		
		@RequestMapping("/removecustomer")
		public String removecustomer(@ModelAttribute Customer c , Model m)
		{
			int i=c.getCustomerid();
			service.removecustomer(i);
			status="customer remove succesfully";
			m.addAttribute("status",status);
			return "message";
		}
		
		@RequestMapping("/displaycustomer")
		public String getAllCustomers(Model m)
		{
			List<Customer> list=service.getAllCustomers();
			m.addAttribute("list", list);
			return "displaycustomers";
		}
		
	}

