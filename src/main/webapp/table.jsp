<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="postings" value='${requestScope["postings"]}' />
<html>
<head>
    <title>Table</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">Mat. Doc.</th>
        <th scope="col">Item</th>
        <th scope="col">Doc. Date</th>
        <th scope="col">Pstng Date</th>
        <th scope="col">Material Description</th>
        <th scope="col">Quantity</th>
        <th scope="col">BUn</th>
        <th scope="col">Amount LC</th>
        <th scope="col">Crcy</th>
        <th scope="col">User Name</th>
        <th scope="col">Is authorized</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="posting" items="${postings}" >
        <tr>
            <td>${posting.matDoc}</td>
            <td>${posting.item}</td>
            <td>${posting.docDate}</td>
            <td>${posting.pstngDate}</td>
            <td>${posting.materialDescription}</td>
            <td>${posting.quantity}</td>
            <td>${posting.bUn}</td>
            <td>${posting.amountLC}</td>
            <td>${posting.crcy}</td>
            <td>${posting.userName}</td>
            <td>${posting.isAuthorized}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
