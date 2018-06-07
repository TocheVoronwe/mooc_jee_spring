<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="_header.jsp" %>

<h1>Liste des commandes</h1>

<c:forEach items="${orders}" var = "o">

    le ${o.createdOn}:
    <strong><fmt:formatNumber value="${o.amount / 100}" type="currency" /></strong>
    (${o.currentStatus})
    <br />

</c:forEach>


<%@include file="_footer.jsp" %>