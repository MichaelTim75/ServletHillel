<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
    <h4>Product List</h4>
    <table border="1">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Cost</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${productList}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.cost}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
