<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Her kan du oprette dig.

    </jsp:attribute>


    <jsp:body>




        <form action="createUser" method="post">
            <label for="name">Navn: </label><br>
            <input type="text" id="name" name="name"/><br><br>
            <label for="email">Email: </label><br>
            <input type="text" id="email" name="email"/><br><br>
            <label for="password">Password: </label><br>
            <input type="text" id="password" name="password"/><br><br>

            <label for="balance">Saldo: </label><br>
            <input type="number" id="balance" name="balance" max="1000" min="0"/><br><br>

            <input type="submit" class="btn btn-info" value="Opret"/>
        </form>

        <h4>${requestScope.msg}</h4>

    </jsp:body>

</t:pagetemplate>