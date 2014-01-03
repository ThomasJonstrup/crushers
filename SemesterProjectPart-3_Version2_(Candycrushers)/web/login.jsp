<%-- 
    Document   : login
    Created on : Sep 30, 2013, 9:19:32 AM
    Author     : Rasmus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link rel="stylesheet" type="text/css" href="style.css">-->
        <link rel="shortcut icon" type="image/x-icon" href="pics/favicon.ico"/>
        <link rel="stylesheet" type="text/css" href="css/CSSFIL.css">
<!--         <script>
            $( "form:first" ).submit(); 
          
        
        </script>-->
        <title>Login</title>
    </head>

    <body align="center">
        
        <!-- Hoved div: -->
    <div id="hoved">

<!-- Top left div: -->
        
<div id="topleft"></div>

<!-- Top div: -->

    <div id="topcenter"></div>
    
<!-- Top right div: -->

    <div id="topright">
        
     <form action="Controller" method="post">
         <fieldset id="fieldsetLogin">
             
             
            <input type="hidden" name="command" value="login_command"/>
            <div>
            <input size="22" type="text" name="username" value="" autofocus required placeholder="&nbsp; Username" /><br>
            <input size="22" type="password" name="password" value="" required placeholder="&nbsp; Password" />
            </div>
<!--            <input type="submit" id="loginSubmit" type="submit" value="login"/>-->
         <a href="Controller?command=login_command"><button>Log in</button></a>
      <p style='color:red'><b>${loginerror}</b></p>
         </fieldset>

        </form>
        
<!--        <button id="applink"><a href="Mobile/MobileA/BankMain.jsp" data-role="button" data-inline="true" data-theme="b">Mobile APP</a></button>-->
    </div>

<!--  Menu div: -->

    <div id="menu">
        
        <div><img src="pics/blue_menu1.png" alt="Candy crush" width="197" height="512"></div>
      
    </div>
    
<!-- Indhold div: -->

     <div id="indhold_login">
<!--      <img src="pics/candy_main.jpg" alt="Candy crush" width="715" height="370">-->
      <h1>Welcome to Candy Bank</h1>
<!--      <p>Login to bank to show your accounts</p>
                <li><a href="Controller?command=show_login">Login</a>-->
      
</div>
       <!-- Top footer div: -->
        
<div id="footer">
    <div>
<p class="footer">Candy Bank Copyright &copy 2013 <br>Email:<a href="mailto:candybank@outlook.com">candybank@outlook.com</a></p>
    </div>
</div>
</div>
       
    </body>
</html>
