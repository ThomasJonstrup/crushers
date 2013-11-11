<%-- 
    Document   : edit_account
    Created on : 03-10-2013, 11:57:24
    Author     : Thomas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" type="image/x-icon" href="pics/favicon.ico"/>
        <link rel="stylesheet" type="text/css" href="css/CSSFIL.css">
        <title>Edit Customer Page</title>
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
        <a id="backToMainViewCustomer" href="Controller?command=main" class ="nav">- Back to main</a>
            </li>
    </div>

 <!-- Indhold div: -->

    <div id="indhold">
   
        
   <input type="hidden" name="customerId" value="${empty customer ? 0 : customer.customerId}" />
        <form action="Controller" >
            <table width="350px" border=0 align="center" style="background-color:transparent;">

                <tr>
                    <td colspan=2  style="font-weight:bold;font-size:20pt;" align="center">Customer editing</td>

                </tr>
                <tr>
                    <th>ID:</th>
                    <td><input type="text" name="customerId" value="${customer.customerId}" readonly=""/></td>
                </tr>
                <tr>
                    <th>First name:</th>
                    <td><input type="text" name="firstName" value="${customer.firstName}" /></td>
                </tr>
                <tr>
                    <th>Last name:</th>
                    <td><input type="text" name="lastName" value="${customer.lastName}" /></td>
                </tr>
                <tr>
                    <th>Email:</th>
                    <td><input type="text" name="email" value="${customer.email}" /></td>
                </tr>
       
                <tr class="ButtonRow">
                    <td colspan="2">
                        <!--<input type="hidden" name="command" value="save_customer"/>-->
                        <button type="submit" name="command" value="save_customer">Save Customer</button>
<!--                        <button type="submit" name="command" value="cancel">Cancel Editing</button>-->
                         <input type="button" value="Back" onclick="javascript:history.go(-1);">
                    </td>
                </tr>
            </table>
        </form>
    </div>
 
<div id="footer">
    <div>
        <p class="footer">Candy Bank 2013<br>Copyright &copy</p>
    </div>                
 </div>
 </div>               
                
    </body>        
        
   
        
</html>
