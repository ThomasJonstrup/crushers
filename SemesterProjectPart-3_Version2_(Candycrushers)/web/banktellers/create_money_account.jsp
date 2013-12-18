<%-- 
    Document   : create_money_account
    Created on : 16-12-2013, 19:19:36
    Author     : Thomas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Create Money Market Account</title>
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
                <h2 style="color: white;">Name: ${currentPerson.firstName}</h2>
                <a href="Controller?command=logout_command"><button>Log out</button></a>
            </div>

            <!--  Menu div: -->

            <div id="menu">
                <li id="linav">
                    <p id="menutop" class="nav">Menu</p>
                    <a id="backToMainViewCustomer" href="Controller?command=main" class ="nav">- Back to main</a>
                </li>
                <li id="linav"><a id="backOnePage" href="javascript:history.back()" class ="nav">- Back one page</a></li>
                
            </div>

            <!-- Indhold div: -->

            <div id="indhold">
                <h1 style="color: black">Create Money market Account</h1>
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
                            <td><input type="text" name="balance" value="" ></td>
                            <td><input type="text" name="customerId" value="" ></td>

                        </tr>

                        <tr>
                            <td></td>
                            <td><input type="submit" name="Submit" value="Create account"></td>
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

    </body>
</html>   

