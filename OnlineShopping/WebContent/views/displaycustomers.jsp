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
	<c:forEach var="Customer" items="${list }">
						<table>
							<tr>
								<td>
									<h4><c:out value="${Customer.getCustomerid()}"></c:out></h4>
								</td>
								<td>
									<h4><c:out value="${Customer.getCustomername()}"></c:out></h4>
								</td>
								<td>
									<h4><c:out value="${Customer.getPassword()}"></c:out></h4>
								</td>	
								<td>
									<h4><c:out value="${Customer.getBalance()}"></c:out></h4>
								</td>	
								
							</tr>
						</table>
	     </c:forEach>

</body>
</html>