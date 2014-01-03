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
        <script src="js/numbers.js"></script>

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
                <li/>

                <div id="menulink">
                    <a href="Controller?command=main" class ="nav">- Back to main</a>
                    <a href="javascript:history.back()" class ="nav">- Back one page</a>
                </div>

            </div
            <!-- Indhold div: -->

            <div id="indhold">

                <h1 class="padding" align="center">Account History</h1>
                <h2 class="padding" align="center">Owner: ${currentPerson.firstName} ${currentPerson.lastName}</h2>

                <c:forEach var="account" items="${currentPerson.accounts}">
                    <h3 class="padding"> Account Type: ${account.accountType}</h3>
                    <h3 class ="padding"> Account number: ${account.accountId}</h3>
                    <h3 class="padding">Account balance: ${account.balance}</h3>

                    <p class="padding">Move money from this account: </p>
                    <form action="Controller" name="form1" align="center">

                        <input type="hidden" name="command" value="move_money"/>
                        <input type="hidden" name="fromAccountId" value="${account.accountId}"/>
                        <p class="padding">To account number: <input type="text" name="toAcountId" value="" onkeypress="return onlyNumbers();"/></p><br/>
                        <p class="padding">Amount of money: <input type="text" name="amount" value="" onkeypress="return onlyNumbers();"/></p><br>
                        <input type="submit" name="submit" value="Submit"/>
                    </form>
                    <form action="Controller" align="center">
                        <input type="hidden" name="accountId" value="${account.accountId}">
                        <input type="hidden" name="command" value="transactions"/>
                        <button type="submit" name="command">Go to transactions</button>
                    </form>
                        <hr>
                </c:forEach>
            </div>

            <div id="footer">
                <div>
<p class="footer">Candy Bank Copyright &copy 2013 <br>Email:<a href="mailto:candybank@outlook.com">candybank@outlook.com</a></p>
                </div>
            </div>

        </div> 

    </body>
</html> 