<%-- 
    Document   : add_bankteller
    Created on : 07-10-2013, 22:19:01
    Author     : Thomas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Bank Teller Page</title>
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
        <li id="linav">
           <p id="menutop" class="nav">Menu</p>
           <a id="backToMainViewCustomer" href="main.jsp" class="nav">Back to main</a>
        </li>
    </div>

 <!-- Indhold div: -->

    <div id="indhold">
<br>
        <form name="BankTeller" method="post">
            <table width="350px" border=0 align="center" style="background-color:lightblue;">


                <tr>
                    <td colspan=2  style="font-weight:bold;font-size:20pt;" align="center">Bank Teller Registration</td>

                </tr>
                <tr>
                    <td colspan=2>&nbsp;</td>

                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="firstName" value="" ></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastname" value=""></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email" value=""></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" value=""></td>
                </tr>
<!--                <tr>
                    <td>Confirm Password</td>
                    <td><input type="password" name="confirmPassword" value=""></td>
                </tr>-->
                <tr>
                    <td></td>
                    <td><input type="submit" name="Submit" value="Save User"></td>
                </tr>
            </table>
        </form>     
        
    </div>
 
 <!-- Footer div: -->
        
   <div id="footer">
        <div>
          <p class="footer">Candy Bank 2013<br>Copyright &copy</p>
        </div>
    
    </div>
       
    </body>
</html>
