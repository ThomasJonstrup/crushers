<%-- 
    Document   : main
    Created on : 23-09-2013, 10:11:12
    Author     : Thomas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" type="image/x-icon" href="pics/favicon.ico"/>
        <!--<link rel="stylesheet" type="text/css" href="style.css">-->
        <link rel="stylesheet" type="text/css" href="css/CSSFIL.css">
        <title>${currentPerson.firstName}'s site</title>
        <script src="js/jquery-2.0.3.js"></script>
        <script>
                    function customer() {
                    $(".bankTeller").hide();
                            $(".manager").hide();
                    }

            function bankTeller() {
            $(".customer").hide();
                    $(".manager").hide();
            }

            function manager() {
            $(".customer").hide();
                    $(".bankTeller").hide();
            }

//            if ({currentPerson.role} == 1){
//            $(customer);
//            }
//            if ({currentPerson.role} == 2){
//                $(bankTeller);
//            }
//            if ({currentPerson.role} == 3){
//                $(manager);
//            }
        </script>
    </head>
    <body>
        
        
        
        
 <!-- Hoved div: -->
    <div id="hoved">


<!-- Top left div: -->

    <div id="topleft"></div>
    
    <!-- Top center div: -->

    <div id="topcenter"></div>
    
    <!-- Top right div: -->

    <div id="topright">
        
            <c:if test="${pageContext.request.isUserInRole('Banktellers')==true}">
                <h2 style="color: white;"> Bankteller ${currentPerson.firstName}</h2>
            </c:if>
                
            <c:if test="${pageContext.request.isUserInRole('Customers')==true}">
                <h2 style="color: white;"> Welcome ${currentPerson.firstName}</h2>
            </c:if>
                
         <a href="Controller?command=logout_command"><button>Log out</button></a>
    </div>

 <!--  Menu div: -->

    <div id="menu">
      <li id="linav">
                <p id="menutop" class="nav">Menu</p>
            </li>
        
        <div id="menulink">
            
            <c:if test="${pageContext.request.isUserInRole('Banktellers')==true}">
            <li id="linav"><a href="Controller?command=show_customers" class="nav bankTeller">- Show Customers</a></li>    
            </c:if>
            <input type="hidden" name="customerId" value="${customer.customerId}"/>
            <li id="linav"><a href="Controller?command=show_own_account" class="nav customer" >- Show Account</a></li>
<!--            <li id="linav"><a href="Controller?command=show_banktellers" class="bankTeller nav">- Show Bank Teller</a></li>-->
             
            <c:if test="${pageContext.request.isUserInRole('Banktellers')==true}">
            <li id="linav"><a href="Controller?command=add_customer_target" class="bankTeller nav">- Add Customer</a></li>
             </c:if>
            <li id="linav"><a href="Controller?command=show_currency" class="bankTeller nav">- Show Currency</a></li>
            <!--<li class="bankTeller"><a href="Controller?command=create_account" class="bankTeller">Create new account</a></li>-->
<!--            <li id="linav"><a href="Controller?command=add_bankteller" class="bankTeller nav">- Add Bank Teller</a></li>-->
        </div>    
            
            <li id="linav">
                <p id="hygge" class="bankTeller nav">Hygge</p>
                
                <a id="wantCandy" href="candy.jsp" class="bankTeller nav">- Want Candy?</a>
            </li>
            
     
         
    </div>

 <!-- Indhold div: -->

    <div id="indhold">
         <img src="pics/candymain.jpg" alt="Candy crush" width="715" height="530">
 
    </div>

 <div id="footer">
    <div>
        <p class="footer">Candy Bank 2013<br>Copyright &copy</p>
    </div>
</div>
 
 
    </div>        

</body>
</html>
