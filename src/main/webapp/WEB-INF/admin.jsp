<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         <p>You are logged in as "${sessionScope.user.email}".</p>
    </jsp:attribute>


    <jsp:body>

        <c:if test="${sessionScope.user == null}">
            <p>You are not logged in yet. You can do it here: <a
                    href="login.jsp">Login</a></p>
        </c:if>

        <form>
            <table>
                <td>
                    <button formaction="admin" formmethod="get" name="item" value="order">Orders</button>
                </td>

                <td>
                    <button formaction="admin" formmethod="get" name="item" value="user">Users</button>
                </td>

                <td>
                    <button formaction="admin" formmethod="get" name="item" value="graphs">Statistics</button>
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
                    </tr>
                    </thead>
                    <c:forEach var="user" items="${requestScope.userList}">
                        <tr>
                            <td>${user.email}</td>
                            <td>

                                <button formaction="userOrders" formmethod="post" name="email" value="${user.email}">See
                                    orders
                                </button>

                            </td>
                            <td>
                                <label for="amount">Amount for depositing to the user's account:</label><br>
                                <input type="number" id="amount" name="amount" min="1" max="999"><br>
                                <br>
                                <button formaction="addMoney" formmethod="post" name="email" value="${user.email}">Add
                                    money
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
                    <th>Order ID</th>
                    <th>Options</th>
                </tr>
                </thead>
                <c:forEach var="order" items="${requestScope.orderList}">
                    <tr>
                        <td>${order.orderid}</td>
                        <td>


                        </td>
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
        </c:if>

        <c:if test="${item=='userOrder'}">
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
        </c:if>

        <c:if test="${item=='graphs'}">
            <table class="graph">
                <caption>Describe this Data</caption>
                <thead>
                <tr>
                    <th scope="col">Item</th>
                    <th scope="col">Percent</th>
                </tr>
                </thead>
                <tbody class="horizontal">
                <tr style="height:85%">
                    <th scope="row">Your Blog</th>
                    <td><span>85%</span></td>
                </tr>
                <tr style="height:23%">
                    <th scope="row">Medium</th>
                    <td><span>23%</span></td>
                </tr>
                <tr style="height:7%">
                    <th scope="row">Tumblr</th>
                    <td><span>7%</span></td>
                </tr>
                <tr style="height:38%">
                    <th scope="row">Facebook</th>
                    <td><span>38%</span></td>
                </tr>
                <tr style="height:35%">
                    <th scope="row">Youtube</th>
                    <td><span>35%</span></td>
                </tr>
                <tr style="height:30%">
                    <th scope="row">LinkedIn</th>
                    <td><span>30%</span></td>
                </tr>
                <tr style="height:5%">
                    <th scope="row">Twitter</th>
                    <td><span>5%</span></td>
                </tr>
                <tr style="height:20%">
                    <th scope="row">Other</th>
                    <td><span>20%</span></td>
                </tr>
                </tbody>
            </table>
        </c:if>


    </jsp:body>

</t:pagetemplate>