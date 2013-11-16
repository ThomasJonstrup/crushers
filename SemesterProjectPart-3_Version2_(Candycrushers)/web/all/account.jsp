<%-- 
    Document   : account
    Created on : 05-09-2013, 20:16:07
    Author     : Thomas
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
  
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${currentPerson.firstName} ${currentPerson.lastName}'s account(s)</title>
  <link rel="shortcut icon" type="image/x-icon" href="pics/favicon.ico"/>
      <link rel="stylesheet" type="text/css" href="css/CSSFIL.css">
    
         <link rel="stylesheet" href="css/jquery-ui-1.10.3.custom.css" />
         <script src="js/jquery-2.0.3.js"></script>   
         <script src="js/jquery-ui-1.10.3.custom.js"></script>        
         <script src="js/jquery.ui.datepicker-da.js"></script>
    
<!--  <script>
$(function() {
    $( "#datepicker" ).datepicker({
      
      
      showOn: "button",
      buttonImage: "images/calendar.gif",
      buttonImageOnly: true
    });
    
  });
  
  $( "form:first" ).submit();
       
  </script>
<style type="text/css">
    .ui-datepicker { font-size: 6.5pt !important; }
</style>-->
    
    
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
<!--        <h2 style="color: white;">Hr. ${currentPerson.firstName}</h2>-->
         <a href="Controller?command=logout_command"><button>Log out</button></a>
    
    </div>

 <!--  Menu div: -->

    <div id="menu">
       
        
        
        <li id="linav">
            <p id="menutop" class="nav">Menu</p>
        <li/>
        
        <div id="menulink">
           <a href="Controller?command=main" class ="nav">- Back to main</a>
        <p class="nav">Transaction</p>
        </div>
<!--         
        <form id="formTransAction" action="Controller">          
            <fieldset id="fieldsetOverførelse">
            <legend style="text-decoration-style: solid"><b>Overførelse</b></legend>
            <input type="hidden" name="command" value="move_money"/>
            <input type="hidden" name="fromAccountId" value="${account.accountId}"/>
           

            <input type="text"  name="toAcountId" value="" autofocus required placeholder="&nbsp; Kontonr.:"/><br/>
            <input type="text" name="amount" value="" required placeholder="&nbsp; Beløb.:"/><br>
            <input type="text" size="17" id="datepicker" required placeholder="&nbsp; Dato.: 01-01-2013"/><br/>
            <input id="SubmitOverførelse" id="submit" type="submit" value="Send"/>
            </fieldset>
        </form>-->
           
      
        </div
      

 <!-- Indhold div: -->

    <div id="indhold">
    
      <h1>Account History</h1>
<!--      <p>Owner: ${currentPerson.firstName} ${currentPerson.lastName}</p>-->

      <c:forEach var="account" items="${currentPerson.accounts}">
      <h2>${account.accountType} - ${account.accountId}</h2>
          
      <p>Move money from this account: </p>
      <form action="Controller">
            
            <input type="hidden" name="command" value="move_money"/>
            <input type="hidden" name="fromAccountId" value="${account.accountId}"/>
            <p>To account number: <input type="text" name="toAcountId" value=""/></p><br/>
            <p>Amount of money: <input type="text" name="amount" value=""/></p><br>
            <input type="submit" value="Submit"/>
        </form>
      <table>
            <thead style="background-color: darkblue; color: white;">
                <tr>
                <td>Date</td>
                <td>Description</td>
                <td>Amount</td>
                <td>Balance</td>
                </tr>
            </thead>
                <c:forEach var="trans" items="${account.transactions}">
                    <tr>
                        <td><fmt:formatDate value="${trans.timestamp}" pattern="dd-MM-YYYY" /></td> 
                        <td>${trans.info}</td>
                        <td>${trans.amount}</td>
                        <td>${trans.balance}</td>
                    </tr>
                </c:forEach>
      </table>
      <br/><br/>
      </c:forEach>
    
    </div>

 <div id="footer">
    <div>
        <p class="footer">Candy Bank 2013<br>Copyright &copy</p>
    </div>
</div>
    
    </div> 

  </body>
</html> 
  
  
  
  
  
  
<!--  </head>
  <body>
      <h1>Account History</h1>
      <p>Owner: ${currentPerson.firstName} ${currentPerson.lastName}</p>

      <c:forEach var="account" items="${currentPerson.accounts}">
      <h2>${account.accountType} - ${account.accountId}</h2>
          
      <p>Move money from this account: </p>
      <form action="Controller">
            
            <input type="hidden" name="command" value="move_money"/>
            <input type="hidden" name="fromAccountId" value="${account.accountId}"/>
            <font color="white">To account number: </font><input type="text" name="toAcountId" value=""/><br/>
            <font color="white">Amount of money: </font><input type="text" name="amount" value=""/><br>
            <input type="submit" value="Submit"/>
        </form>
      <table>
            <thead style="background-color: darkblue; color: white;">
                <tr>
                <td>Date</td>
                <td>Description</td>
                <td>Amount</td>
                <td>Balance</td>
                </tr>
            </thead>
                <c:forEach var="trans" items="${account.transactions}">
                    <tr>
                        <td><fmt:formatDate value="${trans.timestamp}" pattern="dd-MM-YYYY" /></td> 
                        <td>${trans.info}</td>
                        <td>${trans.amount}</td>
                        <td>${trans.balance}</td>
                    </tr>
                </c:forEach>
      </table>
      <br/><br/>
      </c:forEach>
        <a href="main.jsp">Back to main</a>
  </body>
</html>-->
