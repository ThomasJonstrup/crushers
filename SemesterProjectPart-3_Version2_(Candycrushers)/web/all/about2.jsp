<%-- 
    Document   : about2
    Created on : 19-12-2013, 11:27:11
    Author     : Thomas
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" type="image/x-icon" href="pics/favicon.ico"/>
        <!--<link rel="stylesheet" type="text/css" href="style.css">-->
        <link rel="stylesheet" type="text/css" href="css/CSSFIL.css">
        <title>${currentPerson.firstName}'s site</title>
        <script src="js/jquery-2.0.3.js"></script>
    </head>
    <body>

    <body>
        <!-- Hoved div: -->
        <div id="hoved">

            <!-- Top div: -->

            <div id="topleft"></div>

            <!-- Top right div: -->

            <div id="topcenter"></div>

            <!-- Top left div: -->

            <div id="topright">
            <c:if test="${pageContext.request.isUserInRole('Banktellers')==true}">
                <h2 style="color: white;"> Bankteller ${currentPerson.firstName}</h2>
            </c:if>
                
            <c:if test="${pageContext.request.isUserInRole('Customers')==true}">
                <h2 style="color: white;"> Customer ${currentPerson.firstName}</h2>
            </c:if>
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
                <h1 align="center">About Candy Bank</h1>
                <table width="350px" border=0 align="center" style="background-color:transparent;">
                    <!--                        <tr>
                                                <td colspan=2  style="font-weight:bold;font-size:20pt; color: black;" align="center">About Candy Bank</td>
                                            </tr>-->
                    <tr>
                        <td colspan=2>&nbsp;</td>

                    </tr>
                    <tr>
                        <td>Bank name: </td>
                        <td>Candy bank</td>
                    </tr>
                    <tr>
                        <td>Bank adresse: </td>
                        <td>Lundtoftevej 10</td>
                    </tr>
                    <tr>
                        <td>Bank city:</td>
                        <td>Lyngby</td>
                    </tr>
                    <tr>
                        <td>Phone nr:</td>
                        <td>44440244</td>
                    </tr>
                </table>

                <c:if test="${pageContext.request.isUserInRole('Banktellers')==true}">
                    <h2 align="center"> Current number of customer ${count} </h2>
                </c:if>
                <c:if test="${pageContext.request.isUserInRole('Customers')==true}">
                    <h2 align="center"> Current number of banktellers ${countBank} </h2>
                </c:if>

                <%
                    Integer hitsCount =
                            (Integer) application.getAttribute("hitCounter");
                    if (hitsCount == null || hitsCount == 0) {
                        /* First visit */
                        out.println("Welcome to about candybank page!");
                        hitsCount = 1;
                    } else {
                        /* return visit */
                        out.println("Welcome back to candybank page!");
                        hitsCount += 1;
                    }
                    application.setAttribute("hitCounter", hitsCount);
                %>
                <center>
                    <p>Total number of visits: <%= hitsCount%></p>
            </div>
            <div id="footer">
                <div>
<p class="footer">Candy Bank Copyright &copy 2013 <br>Email:<a href="mailto:candybank@outlook.com">candybank@outlook.com</a></p>
                </div>
            </div>

        </div> 

    </body>
</html>
