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
         <script>
            $( "form:first" ).submit();
        </script>
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
        
     <form action="Controller">
         <fieldset id="fieldsetLogin">
             
             
            <input type="hidden" name="command" value="login_command"/>
            <div>
            <input size="10" type="text" name="username" value="" autofocus required placeholder="&nbsp; Username" /><br>
            <input size="10" type="password" name="password" value="" required placeholder="&nbsp; Password" />
            </div>
            <input type="submit" id="loginSubmit" type="submit" value="login"/>
        
         </fieldset>

        </form>
        
            ${loginerror}
        <button id="applink"><a href="Mobile/MobileA/BankMain.jsp" data-role="button" data-inline="true" data-theme="b">Mobile APP</a></button>
    </div>

<!--  Menu div: -->

    <div id="menu">
        
        <div><img src="pics/candy3.jpg" alt="Candy crush" width="197" height="500"></div>
      
    </div>
    

<!-- Indhold div: -->

     <div id="indhold">
      <img src="pics/candymain.jpg" alt="Candy crush" width="715" height="530">
</div>
       <!-- Top footer div: -->
        
<div id="footer">
    <div>
        <p class="footer">Candy Bank 2013<br>Copyright &copy</p>
    </div>
</div>
</div>
       
    </body>
</html>
