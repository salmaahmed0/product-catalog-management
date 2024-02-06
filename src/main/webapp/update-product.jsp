<%@ page import="com.example.productcatalogmanagement.repo.ProductRepository" %>
<%@ page import="com.example.productcatalogmanagement.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Update Product</title>
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

    <div class="container"><h4> Update Product </h4></div>
    <div class="container">
        <form action="update-product" method="post">
            <div class="form-input">ID:
                <div><input type="number" name="item-id" value="<%=request.getAttribute("id")%>" required readonly></div>
            </div>
            <br>
            <div class="form-input">Name:
                <div><input type="text" name="item-name" value="<%=request.getAttribute("name")%>" required></div>
            </div>
            <br>
            <div class="form-input">Price:
                <div><input type="number" name="item-price" value="<%=request.getAttribute("price")%>" required></div>
            </div>
            <br>
            <div class="form-input"><input type="submit" name="submit-item" value="Update"></div>
        </form>
    </div>


</body>
</html>
