<%--
  Created by IntelliJ IDEA.
  User: macbookpro13
  Date: 29/08/2022
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start</title>
</head>
<body>
<button id="myButton1" class="float-left submit-button" >Register</button>

<script type="text/javascript">
    document.getElementById("myButton1").onclick = function () {
        location.href = "http://localhost:8080/register";
    };
</script>

<button id="myButton2" class="float-left submit-button" >Log in</button>

<script type="text/javascript">
    document.getElementById("myButton2").onclick = function () {
        location.href = "http://localhost:8080/login";
    };
</script>
</body>
</html>
