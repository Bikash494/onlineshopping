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

<form action ="paidBill">		
	
	<h2><input type="hidden" name="productno" value="${c.getProductno()}">Product id : ${c.getProductno()}</h2>
	<h2><input type="hidden" name="quantity" value="${c.getQuantity()}">Quantity : ${c.getQuantity()}</h2>
	
	<h2><input type="hidden" name="grandTotal" value="${c.getGrandtotal()}">Grand Total : ${c.getGrandtotal()}</h2>
	<h2><input type="hidden" name="totalDiscount" value="${c.getTotaldiscount()}">Discount on Total : ${c.getTotaldiscount()}</h2>
	<h2><input type="hidden" name="payAmount" value="${c.getPayAmount()}">Total Pay Amount : ${c.getPayAmount()}</h2> 
	
	<center><input type="submit"></center>
	
</form>

</body>
</html>