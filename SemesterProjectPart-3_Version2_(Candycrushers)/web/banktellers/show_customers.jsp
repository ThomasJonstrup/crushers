<%-- 
    Document   : show_customers
    Created on : 23-09-2013, 10:55:38
    Author     : Thomas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <link rel="shortcut icon" type="image/x-icon" href="pics/favicon.ico"/>
        <link rel="stylesheet" type="text/css" href="css/CSSFIL.css">
        
        <title>Show customers</title>
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
        <h2 style="color: white;">Name: ${currentPerson.firstName}</h2>
         <a href="Controller?command=logout_command"><button>Log out</button></a>
    </div>

 <!--  Menu div: -->

    <div id="menu">
        
        <li id="linav">
                <p id="menutop" class="nav">Menu</p>
            </li>
            
<div id="customer">
        <c:forEach items="${customers}" var="customer">
        <li id="linav">
            <a href="Controller?command=view_customer&customerId=${customer.customerId}" class="nav">-
            ${customer.firstName} ${customer.lastName}
          </a>
        </li>
        </c:forEach>
</div>
       
       
        <li id="linav">
                <p id="menutopShowCustomer" class="nav">Kunder</p>
            </li>
     
        
        
        <li id="linav">
<!--        <a id="backToMainShowCustomer" href="all/main.jsp" class="nav">- Back to main</a>-->
        <a id="backToMainShowCustomer" href="Controller?command=main" class ="nav">- Back to main</a>
        </li>
        
        
        
    </div>

 <!-- Indhold div: -->

    <div id="indhold" id="mainpicture">
     
        
        
    </div>
    
    
    <div id="footer">
    <div>
        <p class="footer">Candy Bank 2013<br>Copyright &copy</p>
    </div>
</div>
    </div>

    </body>
</html>
