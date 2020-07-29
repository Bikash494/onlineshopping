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
	<table>
		<caption><font size="6">Cart Products</font></caption>
		<tr>
			<th>Customer ID</th>
			<th>Product No</th>
			<th>Quantity</th>
			<th>Grand Total</th>
			<th>Total Discount</th>
			<th>Payable</th>
		</tr>
		<c:forEach var="Product" items="${list}">
			<tr>
			<td>	<c:out value="${Product.getId() }"></c:out>	</td>
			<td>	<c:out value="${Product.getProductno()}"></c:out></td>
			<td>	<c:out value="${Product.getQuantity()}"></c:out>	</td>
			<td>	<c:out value="${Product.getGrandtotal()}"></c:out>	</td>
			<td>	<c:out value="${Product.getTotaldiscount()}"></c:out>	</td>
			<td>	<c:out value="${Product.getPayAmount()}"></c:out>		</td>
		</tr>
			</c:forEach>
		</table>

</body>
</html>