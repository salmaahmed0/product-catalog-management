
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%@include file="header.jsp"%>
    <style>
        .form-input{
            /*display: flex;*/
            justify-content: center;
            align-items: center;
        }
    </style>
</head>
<body>

    <div class="container"><h4> Login </h4></div>
    <div class="container">
        <form action="login" method="post">
            <div class="form-input"><label>User Name: </label><input type="text" name="user-name"></div>
            <br>
            <div class="form-input"><label>Password : </label><input type="password" name="password"></div>
            <br>
            <div class="form-input"><input type="submit" name="submit-login" value="Login"></div>
        </form>
    </div>
</body>
</html>
