<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test JSP</title>
</head>
<body>
 <p>Hi There </p>
 <p> Session: <%= session.getAttribute("name") %></p>
 <p> Request: <%= request.getAttribute("name") %></p>
 <p> Request (Using EL): ${name}</p>
 <p> <c:out value="${name}"></c:out> </p>
 
<!--  <sql:query var="rs" dataSource="jdbc/springDB">
	select userId, userName from employees
 </sql:query>
 
 <h2>Results</h2>

 <c:forEach var="row" items="${rs.rows}">
    UserID ${row.userId}<br/>
    USerName ${row.userName}<br/>
 </c:forEach> -->
 
 <p><a href="${pageContext.request.contextPath}/employees" >Show Employees</a></p>
</body>
</html>