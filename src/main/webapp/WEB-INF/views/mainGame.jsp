<%--
  Created by IntelliJ IDEA.
  User: macbookpro13
  Date: 27/08/2022
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--    <link href="/resources/css/main.css" rel="stylesheet" type="text/css">--%>
    <style>
        <%@include file="/WEB-INF/css/style.css" %>
    </style>
    <title><<<-AdMech Game->>></title>
</head>
<body>
<div style="float: left ; width: 25% ;text-align: center">
    <h3>     N<br>
             |<br>
        W -- +  -- E<br>
             |<br>
             S
    </h3>
</div>
<div style="float: left ; width: 50% ;text-align: center">
    <h3>${text1}</h3>
    <form method="post">
        <input type="text" name="command"><br>
        <input type="submit" hidden/>
    </form>
</div>
<div style="float: left ; width: 25% ;text-align: center">
    <h3>Right</h3>
</div>
</body>
</html>
