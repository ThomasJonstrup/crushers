<%-- 
    Document   : transaction
    Created on : 28-11-2013, 11:06:49
    Author     : Thomas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
<table>
                        <thead style="background-color: darkblue; color: white;">
                            <tr>
                                <td>Date</td>
                                <td>Description</td>
                                <td>Amount</td>
                                <td>Balance</td>
                            </tr>
                        </thead>
                        <c:forEach var="trans" items="${transactions}">
                            <tr>
                                <td><fmt:formatDate value="${trans.timestamp}" pattern="dd-MM-YYYY" /></td> 
                                <td>${trans.info}</td>
                                <td>${trans.amount}</td>
                                <td>${trans.balance}</td>
                            </tr>
                        </c:forEach>
                    </table>
                    <br/><br/>
    </body>
</html>
