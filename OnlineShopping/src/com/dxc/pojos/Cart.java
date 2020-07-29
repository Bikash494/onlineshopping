package com.dxc.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart {
	
	@Id
	private int serialNo;
	private int id;
	
	private int productno;
	private int quantity;
	private double grandtotal;
	private double totaldiscount;
	private double payAmount;
	
	public Cart() {
		
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductno() {
		return productno;
	}

	public void setProductno(int productno) {
		this.productno = productno;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getGrandtotal() {
		return grandtotal;
	}

	public void setGrandtotal(double grandtotal) {
		this.grandtotal = grandtotal;
	}

	public double getTotaldiscount() {
		return totaldiscount;
	}

	public void setTotaldiscount(double totaldiscount) {
		this.totaldiscount = totaldiscount;
	}

	public double getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}

	@Override
	public String toString() {
		return "Cart [serialNo=" + serialNo + ", id=" + id + ", productno=" + productno + ", quantity=" + quantity
				+ ", grandtotal=" + grandtotal + ", totaldiscount=" + totaldiscount + ", payAmount=" + payAmount + "]";
	}
	
	
}
