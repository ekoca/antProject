<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Welcome back, ${order.customer.name}</h1>

<ul>
<c:forEach items="${order.booksOrdered}" var="book">
	<li>
	
	    ${book.title}  
	
		<form method="post">
		
			<input type="submit" value="Remove Item" name="_eventId_removeBook"/>
			<input type="hidden" name="id" value="${book.id}"/>
		
		</form>
	
	
	</li>
</c:forEach>
</ul> 


<form method="post">
	<input type="submit" value="Press here to continue" name="_eventId_nextStep"/>
</form>   
   		