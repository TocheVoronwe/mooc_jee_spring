<%@include file="_header.jsp" %>
<%-- import required classes --%>

<ul class="categories">
<%-- iterate through categories --%>
<li>
	<%-- set a link to each category content --%>
	<a href="category/${id}.html">
		<%-- 
			add an image related to category ID.
			Category images are located in /img/ and name catID.jpg (ID as 2 digits)
		 --%>
		<img src="/img/cat${id}.jpg"/><br/>
		<%-- Show category name --%>
	</a>
</li>

</ul>
<%@include file="_footer.jsp" %>