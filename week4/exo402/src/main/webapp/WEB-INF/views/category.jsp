<%@include file="_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- import required classes --%>

<ul class="articles">
	<c:forEach items="${articles}" var="a">
<%-- Iterate through articles ... --%>
<li>
<%--	<a href="#">--%>
		<span class="price">
			<%-- show price as X,XX --%> ${(Float.parseFloat(a.price)/100).toString().replace('.', ',')}</span>
		<%-- 
			show product image, you can use 'https://static1.chronodrive.com'
			as base URL and img path to complete the image URL 
		--%>
		<img src="https://static1.chronodrive.com/${a.img}"/><br/>
		<%-- show product name --%><c:out value="${a.name}"></c:out><br/>
	<%--</a>--%>
</li>
	</c:forEach>

</ul>
<%@include file="_footer.jsp" %>