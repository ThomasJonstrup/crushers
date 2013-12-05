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
            function callWhenSuccess(accountExists) {
//                        if (response == "true") $("#email").css("background-color", "#ccffcc");
//                        else $("#email").css("background-color", "red");
                if (accountExists) $("#accountId").removeClass().addClass("Correct");
                else $("#accountId").removeClass().addClass("Wrong");
            }
    
            function checkAccount() {
                // var email = document.getElementById("email").value;
                var account = $("#accountId").val();
                //$("#target").load("AjaxController", { command: "check-email", email: email } );
                $.ajax({
                    url: "AjaxAccountController",
                    data: { command: "check-account", account: account },
                    dataType: "json",
                    success: callWhenSuccess
                })
                
            }
        </script>
    </head>
    <body>
        <h1>Check Account</h1>
        <hr/>
        <input type="text" name="accountId" id="accountId"/>
        <button onclick="checkAccount();">Check</button>
        <div id="target">...</div>
        
    </body>
</html>
