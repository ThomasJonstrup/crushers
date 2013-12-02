<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
            function callWhenSuccess(mailExists) {
//                        if (response == "true") $("#email").css("background-color", "#ccffcc");
//                        else $("#email").css("background-color", "red");
                if (mailExists) $("#email").removeClass().addClass("Wrong");
                else $("#email").removeClass().addClass("Correct");
            }
    
            function checkMail() {
                // var email = document.getElementById("email").value;
                var email = $("#email").val();
                //$("#target").load("AjaxController", { command: "check-email", email: email } );
                $.ajax({
                    url: "AjaxController",
                    data: { command: "check-email", email: email },
                    dataType: "json",
                    success: callWhenSuccess
                })
                
            }
        </script>
    </head>
    <body>
        <h1>Check email</h1>
        <hr/>
        <input type="text" id="email"/>
        <button onclick="checkMail();">Check</button>
        <div id="target">...</div>
        
    </body>
</html>
