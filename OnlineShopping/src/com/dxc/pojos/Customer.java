package com.dxc.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer 
{
	@Id
 private int customerid;
 private String customername;
 private String password;
 private double balance;
 
 public Customer()
 {
	 
 }

public Customer(int customerid, String customername, String password, double balance) {
	super();
	this.customerid = customerid;
	this.customername = customername;
	this.password = password;
	this.balance = balance;
}

public int getCustomerid() {
	return customerid;
}

public void setCustomerid(int customerid) {
	this.customerid = customerid;
}

public String getCustomername() {
	return customername;
}

public void setCustomername(String customername) {
	this.customername = customername;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}
 
 
}
