<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<html>

<head>
	<title>All books for our store</title>
	<link href="<c:url value="/styles.css"/>" rel="Stylesheet" type="text/css"/>
</head>
  
<body>

	<jsp:include page="/header.jsp"/>
	
	<div id="books">
		<ul>
			<c:forEach items="${allBooks}" var="nextBook">
			
			<li>
				<h2>${nextBook.title}</h2>
				<p>
					<span> by  ${nextBook.author}  
					       <fmt:formatNumber value="${nextBook.price}"
					       					 type="currency"
					       					 currencyCode="USD" />			
				
					<form method='post' action='<c:url value="addToCart.do"/>'>
						<input type='hidden' name='id' value='${nextBook.id}'/>
						<input type='image' src='<c:url value="/cart-button.png"/>'/>
				    </form>
				</span>
				</p>
				
			</li>
			
			</c:forEach>
		
		</ul>
	</div>
		
	<jsp:include page="/footer.jsp"/>
	
</body>

</html>