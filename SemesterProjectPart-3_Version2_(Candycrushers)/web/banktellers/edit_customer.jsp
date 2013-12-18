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
    
    <style>
        .Wrong {
            background-color: red;
            color: yellow;
        }
        .Correct {
            background-color: #ccffcc;
        }
    </style> 
    <script src="js/jquery-2.0.3.js"></script>
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
        function callWhenSuccess(mailExists) {
//                        if (response == "true") $("#email").css("background-color", "#ccffcc");
//                        else $("#email").css("background-color", "red");
            if (mailExists)
                $("#email").removeClass().addClass("Wrong");
            else
                $("#email").removeClass().addClass("Correct");
        }

        function checkMail() {
            // var email = document.getElementById("email").value;
            var email = $("#email").val();
            //$("#target").load("AjaxController", { command: "check-email", email: email } );
            $.ajax({
                url: "AjaxController",
                data: {command: "check-email", email: email},
                dataType: "json",
                success: callWhenSuccess
            });

        }

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
        <h2 style="color: white;">Name: ${currentPerson.firstName}</h2>
         <a href="Controller?command=logout_command"><button>Log out</button></a>
    </div>

 <!--  Menu div: -->

    <div id="menu">
        <li id="linav">
                <p id="menutop" class="nav">Menu</p>
        <a id="backToMainViewCustomer" href="Controller?command=main" class ="nav">- Back to main</a>
                    <a href="javascript:history.back()" class ="nav">- Back one page</a>
            </li>
<!--            <li id="linav"><a id="backOnePage" href="javascript:history.back()" class ="nav">- Back one page</a></li>-->
    </div>

 <!-- Indhold div: -->

    <div id="indhold">
   
        
   <input type="hidden" name="customerId" value="${empty customer ? 0 : customer.customerId}" />
<form name="Customer" action="Controller" method="post" onSubmit="return validateForm();">
            <table width="350px" border=0 align="center" style="background-color:transparent;">

                <tr>
                    <td colspan=2  style="font-weight:bold;font-size:20pt;" align="center">Customer editing</td>

                </tr>
                <tr>
                    <th>ID:</th>
                    <td><input type="text" id='custid' name="customerId" value="${customer.customerId}" readonly=""/></td>
                </tr>
                <tr>
                    <th>First name:</th>
                    <td><input type="text" id='firstname' name="firstName" value="${customer.firstName}" /></td>
                </tr>
                <tr>
                    <th>Last name:</th>
                    <td><input type="text"  id='lastname' name="lastName" value="${customer.lastName}" /></td>
                </tr>
                <tr>
                    <th>Email:</th>
                    <td><input type="text" id='email' name="email" value="${customer.email}" /></td>
                    <td><button type="button" onclick="checkMail();">Check</button></td>
                </tr>
                
                <tr class="ButtonRow">
                    <td colspan="2">
<!--                        <input type="hidden" name="command" value="save_customer"/>-->
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
