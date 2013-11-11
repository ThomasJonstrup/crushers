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
        <h2 style="color: black;">Hr. ${currentPerson.firstName}</h2>
         <a href="Controller?command=logout_command"><button>Log out</button></a>
    </div>

 <!--  Menu div: -->

    <div id="menu">
       
     <li id="linav">
       <p id="menutop" class="nav">Menu</p>
       <a id="backToMainViewCustomer" href="main.jsp" class="nav">Back to main</a>
     </li>
    </div>

 <!-- Indhold div: -->

    <div id="indhold">
        <object width="756" height="630" data="pics/candy-crush.swf" type="application/x-shockwave-flash"></object>
    </div>
 
 
 <div id="footer">
    <div>
        <p class="footer">Candy Bank 2013<br>Copyright &copy</p>
    </div>
</div>
        
        
    </body>
</html>
