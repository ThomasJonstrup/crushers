<%-- 
    Document   : show_banktellers
    Created on : 07-10-2013, 22:33:29
    Author     : Thomas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
  <link rel="shortcut icon" type="image/x-icon" href="pics/favicon.ico"/>
         <link rel="stylesheet" href="css/CSSFIL.css" type="text/css"/>
    </head>
    <body>

 <!-- Hoved div: -->
    <div id="hoved">

 <!-- Top div: -->

    <div id="topleft"></div>
    
<!-- Top right div: -->

    <div id="topcenter">
               
    </div>

<!-- Top left div: -->

    <div id="topright">
        <h2 style="color: white;">Hr. ${currentPerson.firstName}</h2>
         <a href="Controller?command=logout_command"><button>Log out</button></a>
    </div>

 <!--  Menu div: -->

    <div id="menu">
        <c:forEach items="${banktellers}" var="bankteller">
<!--            <div> ${bankteller.firstName} ${bankteller.lastName} ${bankteller.email} </div>-->
        <li id="linav">
          <a href="Controller?command=show_banktellers&banktellerId=${bankteller.banktellerId}">
            ${bankteller.firstName} ${bankteller.lastName}
          </a>
        </li>
        </c:forEach> 
    </div>
    <li id="linav">
      <p id="menutop" class="nav">Menu</p>
    </li>
          
          <li id="linav">
                <p id="menutopShowCustomer" class="nav">Banktellers</p>
            </li>
     
        
        
        <li id="linav">
        <a id="backToMainShowCustomer" href="main.jsp" class="nav">- Back to main</a>
        </li>
   
 <!-- Indhold div: -->

    <div id="indhold">

   </div>

 <!-- Footer div: -->
 
 <div id="footer">
    <div>
        <p class="footer">Candy Bank 2013<br>Copyright &copy</p>
    </div>
 </div>
 </div>

 </body>
</html>

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
<!--    </head>
    <body>
        <h1 style="color: black;">Bank Tellers</h1>
        <c:forEach items="${banktellers}" var="bankteller">
            <div> ${bankteller.firstName} ${bankteller.lastName} ${bankteller.email} </div>
        <li>
          <a href="Controller?command=show_banktellers&banktellerId=${bankteller.banktellerId}">
            ${bankteller.firstName} ${bankteller.lastName}
          </a>
        </li>
        </c:forEach>
        <a href="main.jsp">Back to main</a>
    </body>
</html>-->
