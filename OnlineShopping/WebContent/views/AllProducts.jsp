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
		<c:forEach var="Product" items="${list }">
						<table>
							<tr>
								<td>
									<h4><c:out value="${Product.getProductno()}"></c:out></h4>
								</td>
								<td>
									<h4><c:out value="${Product.getProductname()}"></c:out></h4>
								</td>
								<td>
									<h4><c:out value="${Product.getProductcost()}"></c:out></h4>
								</td>	
								<td>
									<h4><c:out value="${Product.getQuantity()}"></c:out></h4>
								</td>	
								<td>
									<h4><c:out value="${Product.getDiscount()}"></c:out></h4>
								</td>	
							</tr>
						</table>
	     </c:forEach>
</body>
</html>