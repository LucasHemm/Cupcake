<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Velkommen ombord
    </jsp:attribute>


    <jsp:body>

        <br>
        <h3>Øens bedste cupcakes. Vælg og bestil her:</h3>

        <form action="addToBasket" method="post">


            <label for="bottoms"><b>Vælg en bund:</b></label>


            <select name="bottom" id="bottoms" value="Bottoms">
                <c:forEach var="item" items="${sessionScope.bottomList}">
                    <option value="${item.bottomid}">${item.type} ${item.price},-</option>

                </c:forEach>
            </select>


            <label for="toppings"><b>Vælg topping:</b></label>

            <select name="topping" id="toppings" value="Toppings">
                <c:forEach var="item" items="${sessionScope.toppingList}">
                    <option value="${item.toppingid}">${item.type} ${item.price},-</option>

                </c:forEach>
            </select>

            <label for="amount"><b>Antal:</b></label>

            <input type="number" id="amount" name="amount" min="1" max="100" value="1"/>

            <button type="submit" class="btn btn-primary">Læg i kurv</button>
        </form>
        <br>
        <h4>${requestScope.msg}</h4>
        <%--        <c:forEach var="item" items="${requestScope.itemList}">--%>
        <%--            <c:if test="${item.done == true}">--%>
        <%--               --%>
        <%--            </c:if>--%>
        <%--        </c:forEach>--%>



    </jsp:body>

</t:pagetemplate>