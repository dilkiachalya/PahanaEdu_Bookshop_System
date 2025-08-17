<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Customer List</title>
    <style>
        table {
            border-collapse: collapse;
            width: 80%;
            margin: auto;
        }
        th, td {
            padding: 8px 12px;
            border: 1px solid #333;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .form-container {
            width: 50%;
            margin: 20px auto;
        }
    </style>
</head>
<body>
<h2 style="text-align: center;">Customers</h2>

<div class="form-container">
    <form action="customers" method="post">
        <input type="text" name="name" placeholder="Name" required />
        <input type="text" name="address" placeholder="Address" required />
        <input type="text" name="phone" placeholder="Phone" required />
        <input type="number" name="unitsConsumed" placeholder="Units Consumed" required />
        <button type="submit">Add Customer</button>
    </form>
</div>

<table>
    <tr>
        <th>Account Number</th>
        <th>Name</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Units Consumed</th>
    </tr>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td>${customer.accountNumber}</td>
            <td>${customer.name}</td>
            <td>${customer.address}</td>
            <td>${customer.phone}</td>
            <td>${customer.unitsConsumed}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
