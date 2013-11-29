<%-- 
    Document   : AddCustomer
    Created on : 28-09-2013, 15:49:06
    Author     : Thomas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Customer Page</title>
        <link rel="shortcut icon" type="image/x-icon" href="pics/favicon.ico"/>
        <link rel="stylesheet" href="css/CSSFIL.css" type="text/css"/>
    </head>
    <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
    <script>
        function validateForm()
        {
            var x = document.forms["Customer"]["email"].value;
            var atpos = x.indexOf("@");
            var dotpos = x.lastIndexOf(".");
            if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= x.length)
            {
                alert("Not a valid e-mail address, missing eitehr @ or a dot");
                return false;
            }
        }
        
        var request;
            function doSomething(field) {
                // alert(field);
                request = new XMLHttpRequest();
                request.open("GET", "Customers?pattern="+field.value, true);
                request.onreadystatechange = function(e) {
                    if (request.readyState != 4) return;
                    if (request.status != 200) return;
                    var html = request.responseText;
                    var target = document.getElementById("target");
                    target.innerHTML = html;
                    };
                request.send();
                }


//        var request;
//        function checkUser(username) {
//            // alert(field);
//            request = new XMLHttpRequest();
//            request.open("GET", "CandyBase?pattern=" + username.value, true);
//            request.onreadystatechange = function(e) {
//                if (request.readyState != 4)
//                    return;
//                if (request.status != 200)
//                    return;
//                var html = request.responseText;
//                var target = document.getElementById("target");
//                target.innerHTML = html;
//            };
//            request.send();
//        }
    </script>


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
                    <a id="backToMainShowCustomer" href="Controller?command=main" class ="nav">- Back to main</a>
                </li>
            </div>

            <!-- Indhold div: -->

            <div id="indhold">
                <br>
                <form name="Customer" action="Controller" method="post" onSubmit="return validateForm();">
                    <input type="hidden" name="command" value="add_customer">
                    <table width="350px" border=0 align="center" style="background-color:transparent;">


                        <tr>
                            <td colspan=2  style="font-weight:bold;font-size:20pt; color: black;" align="center">Customer Registration</td>

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
                            <td><input type="text" name="email" value="" onkeyup="doSomething(this);"></td>
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
                    <div id="target" style="height: 80px;border: 1px solid red;">TODO write content</div>
                </form>

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
