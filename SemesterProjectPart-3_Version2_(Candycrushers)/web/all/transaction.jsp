<%-- 
    Document   : transaction
    Created on : 28-11-2013, 11:06:49
    Author     : Thomas
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" type="image/x-icon" href="pics/favicon.ico"/>
        <link rel="stylesheet" type="text/css" href="css/CSSFIL.css">
        <link rel="stylesheet" href="css/jquery-ui-1.10.3.custom.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Hoved div: -->
        <div id="hoved">

            <!-- Top div: -->

            <div id="topleft"></div>

            <!-- Top right div: -->

            <div id="topcenter"></div>

            <!-- Top left div: -->

            <div id="topright">
                <h2 style="color: white;">Owner: ${currentPerson.firstName}</h2>
                <a href="Controller?command=logout_command"><button>Log out</button></a>

            </div>

            <!--  Menu div: -->

            <div id="menu">
                <li id="linav">
                    <p id="menutop" class="nav">Menu</p>
                    <a id="backToMainShowCustomer" href="Controller?command=main" class ="nav">- Back to main</a>
                    <a id="backOnePage" href="javascript:history.back()" class ="nav">- Back one page</a>
                </li>
            </div>


            <!-- Indhold div: -->

            <div id="indhold">

                <h1 align="center">Transactions</h1>
                <table align="center" border="0" width="350px">
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
            </div>
            <div id="footer">
                <div>
<p class="footer">Candy Bank Copyright &copy 2013 <br>Email:<a href="mailto:candybank@outlook.com">candybank@outlook.com</a></p>
                </div>
            </div>

        </div> 

    </body>
</html> 
