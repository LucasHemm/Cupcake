<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         <p>Velkommen admin fra Olsker.</p>
    </jsp:attribute>


    <jsp:body>


        <form>
            <table>
                <td>
                    <button formaction="admin" class="btn btn-secondary" formmethod="get" name="item" value="order">
                        Ordre
                    </button>
                </td>

                <td>
                    <button formaction="admin" class="btn btn-secondary" formmethod="get" name="item" value="user">
                        Brugere
                    </button>
                </td>

            </table>
        </form>

        <br>


        <c:if test="${item=='user'}">
            <form>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>E-mail</th>
                        <th>Options</th>
                        <th>Indsæt penge: <br>
                            <input type="number" id="amount" name="amount" min="1" max="10000"> ,-<br>
                        </th>
                    </tr>
                    </thead>
                    <c:forEach var="user" items="${requestScope.userList}">
                        <tr>
                            <td>${user.email}</td>
                            <td>

                                <button formaction="userOrders" formmethod="post" name="email" value="${user.email}"
                                        class="btn btn-secondary">Se ordre
                                </button>

                            </td>
                            <td>
                                <button formaction="addMoney" formmethod="post" name="email" value="${user.email}"
                                        class="btn btn-success" max="1000" min="1">Tilføj
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
        </c:if>


        <c:if test="${item=='order'}">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Cupcakes</th>
                    <th>Samlet pris</th>
                    <th>Slet</th>
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
                                    <b>BrugerID:</b> ${order.userid}
                                    <b>Bund:</b> ${cupcake.bottom.type}
                                    <b>Topping:</b> ${cupcake.topping.type}
                                    <b>Antal:</b> ${cupcake.amount}
                                </p>


                            </c:forEach>
                        </td>
                        <td>${order.calcTotalprice()},-</td>

                        <td>
                            <form>
                                <button formaction="deleteOrder" class="btn btn-danger" formmethod="post" name="orderID"
                                        value="${order.orderid}">Slet
                                </button>
                            </form>
                        </td>
                    </tr>

                </c:forEach>
            </table>

        </c:if>

        <c:if test="${item=='userOrder'}">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Cupcakes</th>
                    <th>Samlet pris</th>
                    <th>Slet</th>
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

                        <td>
                            <form>
                                <button formaction="deleteOrder" class="btn btn-danger" formmethod="post" name="orderID"
                                        value="${order.orderid}">Slet
                                </button>
                            </form>
                        </td>
                    </tr>

                </c:forEach>
            </table>
        </c:if>


    </jsp:body>

</t:pagetemplate>