<%--
  Created by IntelliJ IDEA.
  User: Konrad
  Date: 02.08.2018
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.0.0-2/css/bootstrap.css" type="text/css"
          rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <form action="school/delete" method="post">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>#</th>
                <th>Name of school</th>
                <th>Patron</th>
                <th>Address</th>
                <th>Telephone</th>
                <th>Mail</th>
                <th>Id</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="school" items="${schools}" varStatus="loop">
                <tr>
                    <th scope="row">${loop.index + 1}</th>
                    <td>${school.name}</td>
                    <td>${school.patron}</td>
                    <td>${school.address}</td>
                    <td>${school.tellNumber}</td>
                    <td>${school.mail}</td>
                    <td>${school.id}</td>
                    <td><input class="form-check-input" type="radio" name="toJestToId" value="${school.id}" checked></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="/book/add/view"><input type="button" class="btn btn-outline-success" name="action" value="ADD"></a>
        <input type="submit" class="btn btn-outline-danger" name="action" value="DELETE">
    </form>
</div>
</body>
</html>
