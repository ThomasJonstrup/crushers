<%-- 
    Document   : Logon
    Created on : 15-11-2013, 12:57:21
    Author     : Thomas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Bank app mobile</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://code.jquery.com/mobile/1.2.0/jquery.mobile-1.2.0.min.css">
    <script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
    <script src="http://code.jquery.com/mobile/1.2.0/jquery.mobile-1.2.0.min.js"></script>
</head>
<body>
    <div data-role="page">
<div data-role="header">
            <h1>Money Bank</h1>
        </div><!-- /header -->
        
        
 
        <div data-role="content">
            <p></p>
            <div data-role="footer">
            <h4>Logon</h4>
            </div>
            
            <div data-role="fieldcontain">
    <label for="name">Username:</label>
    <input type="text" name="name" id="name" value=""  />
</div>	
<div data-role="fieldcontain">
    <label for="name">Password:</label>
    <input type="text" name="name" id="name" value=""  />
</div>	
            
<a href="LoginPage.jsp" data-role="button" data-inline="true" data-theme="b">Login</a>
<a href="BankMain.jsp" data-role="button" data-inline="true">Cancel</a>

<div data-role="footer" data-id="foo1" data-position="fixed">
	<div data-role="navbar">
		<ul>
			<li><a href="https://maps.google.dk/maps?q=lyngby+handelsskole&ie=UTF-8&ei=x85XUofMCOLy4QSy7YHYBA&ved=0CAoQ_AUoAg">Info</a></li>
			<li><a href="http://www.skype.com/da/">Call</a></li>
			<li><a href="http://www.frisms.nu/">SMS</a></li>
			<li><a href="https://www.hotmail.com">Email</a></li>
		</ul>
		</ul>
	</div><!-- /navbar -->
</div><!-- /footer -->          
</html>
