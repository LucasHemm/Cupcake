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

        <p>This is your customer page</p>


        <p>Name: ${sessionScope.user.name} <br/>
        Email: ${sessionScope.user.email}<br/>
        Password: ${sessionScope.user.password} <br/>
        Balance: ${sessionScope.user.balance}</p>


        <table class="table table-striped">
            <thead>
            <tr>
                <th>Order ID</th>
                <th>Options</th>
            </tr>
            </thead>
            <c:forEach var="order" items="${requestScope.orderList}">
                <tr>
                    <td>${order.orderid}</td>
                    <td>
                        <form>
                            <button formaction="deleteOrder" formmethod="post" name="orderID"
                                    value="${order.orderid}">Delete
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>


    </jsp:body>

</t:pagetemplate>