<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Profil oversigt.
    </jsp:attribute>


    <jsp:body>




        <p> <b>Name:</b> ${sessionScope.user.name} <br/>
            <b>Email:</b> ${sessionScope.user.email}<br/>
            <b>Saldo:</b> ${sessionScope.user.balance},-</p>


        <table class="table table-striped">
            <thead>
            <tr>
                <th>Cupcakes</th>
                <th>Samlet pris pr ordre.</th>
            </tr>
            </thead>
            <c:forEach var="order" items="${requestScope.orderList}">
                <tr>
                    <td>
                        <b>Ordre id:</b> ${order.orderid}
                        <b>Dato:</b> ${order.time}
                        <br>
                    <c:forEach var="cupcake" items="${order.cupcakeList}">

                            <p>

                                <b>Bund:</b> ${cupcake.bottom.type}
                                <b>Topping:</b> ${cupcake.topping.type}
                                <b>Antal:</b> ${cupcake.amount}
                            </p>





                    </c:forEach>
                        </td>
                    <td>${order.calcTotalprice()},-</td>
                </tr>

            </c:forEach>
        </table>


    </jsp:body>

</t:pagetemplate>