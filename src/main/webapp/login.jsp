<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Log ind
    </jsp:attribute>


    <jsp:body>

        <h3>Du kan logge ind her</h3>

        <form action="login" method="post">
            <label for="email">Email: </label>
            <input type="text" id="email" name="email"/>
            <label for="password">Password: </label>
            <input type="password" id="password" name="password"/>
            <input type="submit" class="btn btn-info" value="Log ind" />
        </form>

    </jsp:body>
</t:pagetemplate>