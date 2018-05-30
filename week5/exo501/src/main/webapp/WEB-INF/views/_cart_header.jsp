<pre>
PanierTest-

    <ul class="articles"></ul>
    <c:forEach items="${articles}" var="item">

    <li>
        <p><output>${article.nom}</output></p>
        <p>${article.prix} €</p>
    </li>
    </c:forEach>
</pre>
<a class="btn btn-primary" href="cart/1/validate.html">Commander</a