<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Konrad
  Date: 07.08.2018
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>School registration form</title>
    <style>
        .error {color:red}
        .errorFreePasses {color:blue}
    </style>
</head>
<body>
<div id="container">
    <h3>Save Customer</h3>
    <form:form action="/school/add" modelAttribute="school" method="post">
        <table>
            <tbody>
            <tr>
                <td><label>School name:</label></td>
                <td><form:input path="name" /></td>
            </tr>
                <form:errors path="name" cssClass="error"/>

            <tr>
                <td><label>School addres:</label></td>
                <td><form:input path="address" /></td>
            </tr>
            <tr>
                <td><label>Tell number:</label></td>
                <td><form:input path="tellNumber" /></td>
            </tr>
            <form:errors path="tellNumber" cssClass="error"/>
            <tr>
                <td><label>Patron:</label></td>
                <td><form:input path="patron" /></td>
            </tr>
                <form:errors path="patron" cssClass="error"/>
            <tr>
                <td><label>Email:</label></td>
                <td><form:input path="mail" /></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save" /></td>
            </tr>
            </tbody>
        </table>
    </form:form>

    <p>
        <a href="${pageContext.request.contextPath}/">Back to List</a>
    </p>
</div>
</body>
</html>
