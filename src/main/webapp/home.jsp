<%--
  Created by IntelliJ IDEA.
  User: ASD
  Date: 1/27/2024
  Time: 12:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Catalog</title>
    <%@include file="header.jsp"%>

    <style>
        .container{
            text-align: center;
        }
        .link-container {
            width: 60%;
            margin: 0 auto;
            text-align: center;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        .link-container a {
            display: block;
            text-decoration: none;
            color: #333;
            font-weight: bold;
            font-size: 16px;
            padding: 10px;
            transition: background-color 0.3s;
        }

        .link-container a:hover {
            background-color: #f0f0f0;
        }

        body {
            padding: 20px;
        }
    </style>

</head>
<body>
<div class="container">
    <h3>Hello from Home Page, Please Login</h3>
    <br>
    <div class="link-container"><a href="login.jsp">Login</a></div>
</div>
</body>
</html>
