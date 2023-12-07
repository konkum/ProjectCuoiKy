<%-- 
    Document   : studentlist
    Created on : Dec 3, 2023, 9:01:06 PM
    Author     : Admin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="/ProjectCuoiKy/test" method="post">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Dob</th>
                    <th>Department</th>
                    <th>Select</th>
                </tr>
                <c:forEach var="student" items="${listStudent}">
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.name}</td>
                        <td>${student.dob}</td>
                        <td>${student.department}</td>
                        <td>
                            <c:if test="${student.selected == 0}">
                                <input type="hidden" name="id" value="${student.id}"> 
                                <button type="submit">Select</button>
                            </c:if>
                            <c:if test="${student.selected == 1}">
                                <p>Selected</p>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>
