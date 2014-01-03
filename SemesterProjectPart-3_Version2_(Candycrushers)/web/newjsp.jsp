<%-- 
    Document   : newjsp
    Created on : 29-12-2013, 18:09:27
    Author     : Thomas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head> 
      <title>Form</title> 
      <style type="text/css"> 
         input{ 
         text-align:center; 
         } 
      </style> 
   </head> 
   <body> 
   <form action="post.php"> 
      <label for="text">Text:</label> 
      <input type="text" name="text" id="text" size="10" maxlength="10" /> 
   </form> 
   </body> 
</html>
