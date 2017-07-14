<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee JSP Page</title>
</head>
<body>
 <sql:query var="rs" dataSource="jdbc/springDB">
	select userId, userName from employees
 </sql:query>
 
 <h2>Results</h2>

<!--  <c:forEach var="row" items="${rs.rows}">
    UserID ${row.userId}<br/>
    USerName ${row.userName}<br/>
 </c:forEach>  -->
 	<c:forEach var="row" items="${employees}">
 		<c:out value="${row}"></c:out>
 		<p><%System.out.println("\n"); %></p>
 	</c:forEach>
 
</body>
</html>