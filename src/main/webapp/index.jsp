<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         <h2>Velkommen til Olsker cupcakes.</h2>
         <h5>Venligst log ind, eller opret dig som ny kunde.</h5> <br>
    </jsp:attribute>


    <jsp:body>

        <c:if test="${sessionScope.user == null}">
            <p>Log ind her: <a href="login.jsp">Log ind</a></p>
        </c:if>
        <c:if test="${sessionScope.user == null}">
            <p>Du kan oprette dig som kunde her: <a href="createUser">Opret</a></p>
        </c:if>

    </jsp:body>

</t:pagetemplate>