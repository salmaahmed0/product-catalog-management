<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Add new Product</title>
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
    <div class="container"><h4> Add Product </h4></div>
    <div class="container">
        <form action="add-product" method="post">
            <div class="form-input">Name:<input type="text" name="item-name"></div>
            <br>
            <div class="form-input">Price:<input type="number" name="item-price"></div>
            <br>
            <div class="form-input"><input type="submit" name="submit-item" value="Add"></div>
        </form>
    </div>
</body>
</html>
