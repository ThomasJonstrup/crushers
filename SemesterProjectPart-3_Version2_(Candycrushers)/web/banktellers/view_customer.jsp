<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--        <link rel="stylesheet" type="text/css" href="style.css">-->
        <link rel="shortcut icon" type="image/x-icon" href="pics/favicon.ico"/>
        <link rel="stylesheet" type="text/css" href="css/CSSFIL.css">
        <title>View Customer page</title>
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
        <a id="backToMainViewCustomer" href="Controller?command=main" class ="nav">- Back to main</a>

        </li>
        
            
    </div>

 <!-- Indhold div: -->

    <div id="indhold">
        <br>
        
        <form action="Controller" method="post">
            <input type="hidden" name="customerId" value="${empty customer ? 0 : customer.customerId}" />
            <table width="350px" border=0 align="center" style="background-color:transparent;">


                <tr>
                    <td colspan=2  style="font-weight:bold;font-size:20pt;" align="center">Customer Registration</td>

                </tr>
                <tr>
                    <th>ID:</th>
                    <td>${customer.customerId}</td>
                </tr>
                <tr>
                    <th>First name:</th>
                    <td>${customer.firstName}</td>
                </tr>
                <tr>
                    <th>Last name:</th>
                    <td>${customer.lastName}</td>
                </tr>
                <tr>
                    <th>Email:</th>
                    <td>${customer.email}</td>
                </tr>
                <tr class="ButtonRow">
                    <td colspan="2">
                        <button type="submit" name="command" value="edit_customer">Edit</button>
                        <!--                        <button type="submit" name="command" value="show_customers">List</button>-->
                    </td>
                </tr>
            </table>
            <input type="hidden" name="customerId" value="${customer.customerId}"/>
            <div style="text-align: center;">
            <button type="submit" name="command" value="show_account" >Show accounts</button>
            </div><br><hr>
            <!--<a href="Controller?command=show_account">Show Account</a>-->
        </form>

        <h1 style="text-align: center;">Create Account</h1>
        <form  action="Controller" name="userform" method="post">
            <table width="350px" border=0 align="center" style="background-color:transparent;">


                <tr>
                    <td colspan=2  style="font-weight:bold;font-size:20pt;" align="center">Create account</td>

                </tr>
                <tr>
                    <td colspan=2>&nbsp;</td>

                </tr>
                <tr>
                    <td>Account type</td>
                    <td><input type="text" name="accountType" value="" required></td>
                    
                </tr>

                <tr>
                    <td></td>
                    <td><input type="submit" name="Submit" value="Create account"></td>
                <input type="hidden" name="customerId" value="${customer.customerId}"/>
                <input type="hidden" name="command" value="add_account">
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
