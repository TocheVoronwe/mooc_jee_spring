<%@include file="_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- import required classes --%>

<ul class="categories">
    <c:forEach items="${categories}" var="c">
        <%-- iterate through categories --%>
        <li>
                <%-- set a link to each category content --%>
            <a href="category/${c.id}.html">
                    <%--
                        add an image related to category ID.
                        Category images are located in /img/ and name catID.jpg (ID as 2 digits)
                     --%>
                <img src="../img/cat${String.format("%02d", Integer.parseInt(c.id))}.jpg"/><br/>
                        <label><c:out value="${c.name}"></c:out></label>
                    <%-- Show category name --%>
            </a>
        </li>
    </c:forEach>
</ul>
<%@include file="_footer.jsp" %>