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
<c:forEach var="Product" items="${list }">
<form action = "show">
						
									<tr>	
									<td>
									<h2><input type="hidden" name="productno" value="${Product.getProductno()}">${Product.getProductno()}</h2>
									</td>
				                    <td>
				                    <h1><input type="hidden" name="productname" value="${Product.getProductname()}">${Product.getProductname()}</h1>
				                    </td>

								    <td>
									<h2><input type="hidden" name="productcost" value="${Product.getProductcost()}">${Product.getProductcost()}</h2>
									</td>
							           <td>
									<h2><input type="hidden" name="quantity"  value="${Product.getQuantity()}">${Product.getQuantity()}</h2>
									</td>
								        <td>
									<h2><input type="hidden" name="discount"  value="${Product.getDiscount()}">${Product.getDiscount()}</h2>
									</td>
									<td>
									<input type="submit" >
									</td>
									</tr>						
						</form>
	     </c:forEach>
	     </table>

</body>
</html>