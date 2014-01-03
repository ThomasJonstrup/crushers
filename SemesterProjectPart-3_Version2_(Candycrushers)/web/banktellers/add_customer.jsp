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
        <meta name="viewport" content="width=device-width">
        <title>Add Customer Page</title>
        <link rel="shortcut icon" type="image/x-icon" href="pics/favicon.ico"/>
        <link rel="stylesheet" href="css/CSSFIL.css" type="text/css"/>
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
    <!--    <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>-->
    <script src="js/jquery-2.0.3.js"></script> 
    <script src="js/numbers.js"></script>
    <script>
        function validateForm()
        {
            var x = document.forms["Customer"]["email"].value;
            var atpos = x.indexOf("@");
            var dotpos = x.lastIndexOf(".");
            if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= x.length)
            {
                alert("Not a valid e-mail address, missing either @ or a dot");
                return false;
            }
        }
//OOOOOOOOOOOOOOOOOOO Hent fra tlf. nr. OOOOOOOOOOOOOOOOOOO
//        $(document).ready(function() {
//            $("#btn").click(function() {
        function getPhone() {
                $.ajax({
                    url: "PersonServlet", // En streng "String", som indeholder URL, hvor requestet bliver sendt
                    data: "phone=" + $("#phone1").val(), // 
                    cache: false, // det vil tvinge anmodet sider ikke at blive cached af browseren
                    dataType: "json", // typen af data, som du formoder bliver sendt tilbage
                    //json:  Evaluerer respons som JSON og returnerer et JavaScript objekt.
                    success: function(data) { // En funktion som kaldes når request har succes
                        $("#firstname").val(data.firstName);
                        $("#lastname").val(data.lastName);
                        $("#street").val(data.address.street);
                        $("#email").val(data.email);
                    }
                    // error en funktion som kaldes hvis request fejler 
                });


            }
//OOOOOOOOOOOOOOOOOOO Hent fra tlf. nr. SLUT OOOOOOOOOOOOOOOOOOO

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

        function callWhenSuccessRKI(mailExists) {
//                        if (response == "true") $("#email").css("background-color", "#ccffcc");
//                        else $("#email").css("background-color", "red");
            if (mailExists)
                $("#emailRKI").removeClass().addClass("Wrong");
            else
                $("#emailRKI").removeClass().addClass("Correct");
        }

        function checkMailRKI() {
            // var email = document.getElementById("email").value;
            var checkEmail = $("#emailRKI").val();
            //$("#target").load("AjaxController", { command: "check-email", email: email } );
            $.ajax({
                url: "RKIServlet",
                data: {checkEmail: checkEmail},
                dataType: "json",
                success: callWhenSuccessRKI
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
                <h2 style="color: white;">Hr. ${currentPerson.firstName}</h2>
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
                <!--<form name="RKIForm" action="RKIServlet" method="post">-->
                <br>
                <a>Check Creditworth:  </a><input type="text" id="emailRKI" name="emailRKI" > 
                <button id="btnRKI" onclick="checkMailRKI();">Check rki</button>
                <br>
                <br>
                <!--</form>-->             

                <a>Get from Phone number:  </a><input type="text" id="phone1" onkeypress="return onlyNumbers();"> 
                <button id="btn" onclick ="getPhone();">Get address from phone number</button>
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
                            <td><input type="text" id="firstname" name="firstName" value="" onkeypress="return onlyLetters();"></td>
                        </tr>
                        <tr>
                            <td>Last Name</td>
                            <td><input type="text" id="lastname" name="lastname" value="" onkeypress="return onlyLetters();"></td>
                        </tr>
                        <tr>
                            <td>Email</td>
                            <td><input type="text" id="email" name="email" value=""></td>
                            <td><button type="button" color="blue" onclick="checkMail();">Check</button></td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td><input type="password" name="password" value=""></td>
                        </tr>
<!--                        <tr>
                            <td>Adress</td>
                            <td><input type="text" id="street" name="street"/></td>
                        </tr>-->
                        <!--                <tr>
                                            <td>Confirm Password</td>
                                            <td><input type="password" name="confirmPassword" value=""></td>
                                        </tr>-->
                        <tr>
                            <td></td>
                            <td><input type="submit" name="Submit" value="Save User"></td>

                        </tr>
                    </table>
                    <!--                    <div id="target" style="height: 80px;border: 1px solid red;">TODO write content</div>-->
                </form>

            </div>

            <!-- Footer div: -->

            <div id="footer">
                <div>
<p class="footer">Candy Bank Copyright &copy 2013 <br>Email:<a href="mailto:candybank@outlook.com">candybank@outlook.com</a></p>
                </div>

            </div>   
        </div>

    </body>
</html>
