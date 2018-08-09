<%--
  Created by IntelliJ IDEA.
  User: Konrad
  Date: 05.08.2018
  Time: 00:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.0.0-2/css/bootstrap.min.css" type="text/css"
          rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <form action="/school/add" method="post">
        <div class="row">
            <div class="col-sm-6">
                <div class="form-group">
                    <label for="name">Name of school</label>
                    <input type="text" class="form-control" id="name" name="name" value="${school.name}">

        <input type="submit" value="Add" class="btn btn-success">
        <a href="/">
            <button type="button" class="btn btn-outline-secondary">Cancel</button>
        </a>
    </form>
</div>
</body>
</html>
