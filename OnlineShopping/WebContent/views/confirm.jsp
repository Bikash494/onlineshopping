<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action ="addtocart">

				<h2>Your Cart Bill</h2> <hr>
				<h3><input type="hidden" name="productno" value="${product.getProductno()}">Product no : ${product.getProductno()}</h3>
				<h3><input type="hidden" name="productname" value="${product.getProductname()}">Product Name : ${product.getProductname()}</h3>				
				<h3><input type="hidden" name="productcost" value="${product.getProductcost()}">Price : ${product.getProductcost()}</h3>
				<h3><input type="hidden" name="quantity" value="${product.getQuantity()}">Quantity : ${product.getQuantity()}</h3>
				<h3><input type="hidden" name="discount" value="${product.getDiscount()}">Discount : ${product.getDiscount()} </h3>
				
				<c:set var="price" value="${product.getProductcost()}"></c:set>
				<c:set var="quantity" value="${product.getQuantity()}"></c:set>
				<c:set var="discount" value="${product.getDiscount() / 100}"></c:set>
				<c:set var="grandtotal" value="${product.getProductcost() * product.getQuantity()}"></c:set>
				<c:set var="totaldiscount" value="${grandtotal * (discount)}"></c:set>
				<c:set var="payAmount" value="${grandtotal - totaldiscount}"> </c:set>
				
				<h3><input type="hidden" name="grandtotal" value="${grandtotal}">Grand Total : ${grandtotal}</h3>
				<h3><input type="hidden" name="totaldiscount" value="${totaldiscount}">Total Discount : ${totaldiscount}</h3>
				<h3><input type="hidden" name="payAmount" value="${payAmount}">Pay Amount : ${payAmount}</h3> 
				
				<input type="submit">
				
			</form>
			
</body>
</html>