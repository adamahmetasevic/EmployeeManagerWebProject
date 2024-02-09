<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Employees</title>
</head>
<body>
    <h1>List of Employees</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Position</th>
        </tr>
        <!-- Iterate over the list of employees and display them in the table -->
        <c:forEach items="${employees}" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.position}</td>
            </tr>
        </c:forEach>
    </table>
    
        <a href="index.jsp">Back to Home</a>
    
</body>
</html>
