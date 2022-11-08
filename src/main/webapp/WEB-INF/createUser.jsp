<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Welcome to the sign up page
    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>

        <p>create user page. </p>

        <h3>You can create a user here</h3>

        <form action="createUser" method="post">
            <label for="name">Name: </label>
            <input type="text" id="name" name="name"/>
            <label for="email">email: </label>
            <input type="text" id="email" name="email"/>
            <label for="password">Password: </label>
            <input type="text" id="password" name="password"/>
            <label for="balance">balance: </label>
            <input type="text" id="balance" name="balance"/>

            <input type="submit"  value="Create"/>
        </form>



    </jsp:body>

</t:pagetemplate>