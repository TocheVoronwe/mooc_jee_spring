<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="_header.jsp" %>
<%--<pre>--%>

<c:choose>
    <%-- Pas d'articles --%>
    <c:when test="${empty cart.articles}">
        Aucun article
    </c:when>
    <%-- Il y a des articles --%>
    <c:otherwise>
        <ul>
            <c:forEach items="${cart.articles}" var="a">
                <li>
                        ${a.name}
                    <fmt:formatNumber value="${a.price / 100}" type="currency" />
                </li>
            </c:forEach>
        </ul>
    </c:otherwise>
</c:choose>

<%--</pre>--%>

<a class="btn btn-primary" href="cart/1/validate.html">Commander</a>