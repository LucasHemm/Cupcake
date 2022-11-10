<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>


<t:pagetemplate>
    <jsp:attribute name="header">
         Din kurv <br/>
    </jsp:attribute>

    <jsp:body>


        <form method="post">


        <table class="table table-striped">
            <thead>
            <tr>
                <th>Detaljer</th>
                <th>Pris</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach var="cupcake" items="${sessionScope.basket.cupcakeArrayList}">

                <tr>
                    <td>
                        <p>
                            <b>Bund:</b> ${cupcake.bottom.type}
                            <b>Topping:</b> ${cupcake.topping.type}
                            <b>Antal:</b> ${cupcake.amount}
                        </p>
                    </td>
                    <td>
                        <b>Price:</b> ${cupcake.price},-

                    </td>
                        <%--                    buttons--%>
                    <td>
                        <form method="post">
                                <button formaction="deleteFromBasket" type="submit" class="btn btn-danger"
                                        name="cupcakeId" value="${cupcake.cupcakeId}">Slet</button>
                        </form>
                    </td>
                </tr>

            </c:forEach>
        </table>
        <div class=" d-flex justify-content-end">
            <p>
                <b>Samlet pris:</b> ${sessionScope.totalPrice},-
            </p>
        </div>
        <c:if test="${sessionScope.basket.cupcakeArrayList.size() != 0}">
           <h5>${requestScope.msg}<br/></h5>
        <form method="post">
            <div class="float-end">
                <button formaction="pay" type="submit" class="btn btn-success" name="0">Betal</button>
            </div>
        </form>
        </c:if>


    </jsp:body>

</t:pagetemplate>