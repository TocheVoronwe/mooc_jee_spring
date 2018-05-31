<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<pre>
PanierTest
    <ul class="articles"></ul>
    <c:choose>
        <c:when test="${articles.length == 0}">
            aucun article
        </c:when>
        <c:when test="${articles.length > 0}">
            <c:forEach items="${articles}" var="item">
            <li>
                <p><output>${article.nom}</output></p>
                <p>${article.prix} €</p>
            </li>
            </c:forEach>
        </c:when>
    </c:choose>
</pre>
<a class="btn btn-primary" href="cart/1/validate.html">Commander</a>