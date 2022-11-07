<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Velkommen ombord
    </jsp:attribute>

    <jsp:attribute name="footer">
        Logged in area
    </jsp:attribute>

    <jsp:body>

        <br>
        <h3>Øens bedste cupcakes. Vælg og bestil her:</h3>

        <c:if test="${sessionScope.user != null}">
            <p>You are logged in with the role of admin is ="${sessionScope.user.admin}".</p>
        </c:if>

        <form action="#" method="post">
<%--            ***************^^^^^^^^^^^^^^^^--%>

            <label for="bottoms">Choose a bottom:</label>


            <select name="bottoms" id="bottoms" value="Bottoms">
                <c:forEach var="item" items="${sessionScope.bottomList}">
                    <option value="${item.type}">${item.type}</option>

                </c:forEach>
            </select>


            <label for="toppings">Choose a topping:</label>

            <select name="toppings" id="toppings" value="Toppings">
                <c:forEach var="item" items="${sessionScope.toppingList}">
                    <option value="${item.type}">${item.type}</option>

                </c:forEach>
            </select>

            <label for="amount">Amount:</label>

            <input type="text" id="amount" name="amount"/>

            <button type="submit" class="btn btn-primary">Læg i kurv</button>

        </form>
        <%--        <c:forEach var="item" items="${requestScope.itemList}">--%>
        <%--            <c:if test="${item.done == true}">--%>
        <%--               --%>
        <%--            </c:if>--%>
        <%--        </c:forEach>--%>


        <c:if test="${sessionScope.user == null}">
            <p>You are not logged in yet. You can do it here: <a
                    href="../login.jsp">Login</a></p>
        </c:if>

    </jsp:body>

</t:pagetemplate>