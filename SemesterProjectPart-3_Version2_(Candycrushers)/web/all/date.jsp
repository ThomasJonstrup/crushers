<%-- 
    Document   : date
    Created on : 01-01-2014, 16:37:57
    Author     : Thomas
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
<script>
function my_curr_date() {      
var currentDate = new Date();
      var day = currentDate.getDate();
      var month = currentDate.getMonth() + 1;
      var year = currentDate.getFullYear();
 var my_date = month+"-"+day+"-"+year;
// document.getElementById("dateField").value=my_date;
    document.write(day + "-" + month +"-"+year);
}
</script>
       
    </head>
    <body>
        <h1>Hello World!</h1>
<input type='text' name='dateField' id='dateField' value='' />
   
<h4>It is now  
<script type="text/javascript">
<!--
var currentTime = new Date();
var month = currentTime.getMonth() + 1;
var day = currentTime.getDate();
var year = currentTime.getFullYear();
document.write(month + "/" + day + "/" + year);
//-->
</script>
</h4

</body>
</html>
