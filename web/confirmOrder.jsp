<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Order Confirmation</h1>

<ul>
<c:forEach items="${order.booksOrdered}" var="book">
	<li>	
	    ${book.title}  		
	</li>
</c:forEach>
</ul> 

<form method="post">
	<input type="submit" name="_eventId_confirm" value="Click to confirm the order"/>
</form>