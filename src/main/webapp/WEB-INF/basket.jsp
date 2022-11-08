<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>


<t:pagetemplate>
    <jsp:attribute name="header">
         Din kurv
    </jsp:attribute>

    <jsp:body>


        <form action="BasketServlet" method="get">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Cupcake</th>
                    <th>Pris</th>
                </tr>
                </thead>
                <c:forEach var="cupcake" items="${sessionScope.basket.getOrder}">
                        <tr>
                            <td>${cupcake.name} (${cupcake.created})</td>
                            <td>
                                <button formaction="fjern" name="item_id" value="${cupcake.id}">Fjern</button>
                            </td>
                        </tr>
                </c:forEach>
            </table>
        </form>

        Du har nu tilføjet ${sessionScope.amount} cupcakes til din kurv
        <br><br>

        <h1>Session</h1>
        (Session : ) De tilføjede cupcakes er følgende ${sessionScope.orderList}
        <br><br>


    </jsp:body>

</t:pagetemplate>