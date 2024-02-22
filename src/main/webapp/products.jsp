<%@ page import="java.util.List" %>
<%@ page import="com.example.productcatalogmanagement.entity.Products" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Products> products = (List<Products>) request.getAttribute("products-list");

%>

<html>
<head>
    <title>Products</title>
    <%@include file="header.jsp"%>
    <style>
        .btn-container{
            display: flex;
            justify-content: center;
            align-items: center;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="card-header my-3">All Products</div>
    <div class="row">

        <%
            if(products!=null)
            for (Products item : products){
        %>
        <div class="col-md-3 my-3">
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title"><%= item.getName() %></h5>
                    <p class="card-text"><%= item.getPrice() %></p>
                    <a href="update?id=<%=item.getId()%>" class="btn btn-primary">Update</a>
                    <a href="delete?id=<%=item.getId()%>" class="btn btn-primary">Delete</a>
                </div>
            </div>
        </div>

        <%
            }
        %>

    </div>
    <br>
    <hr>
    <br>
    <div class="btn-container">
        <button type="button" class="btn btn-primary btn-lg"><a href="add-product" style="color: inherit; text-decoration: none;">Add new Product</a></button>
    </div>
</div>

</body>
</html>
