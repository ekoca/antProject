<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
   <head>
   	<title>Enter a new book</title>
   	<link href="<c:url value="/styles.css"/>" rel="Stylesheet" type="text/css"/>   
   </head>

   <body>
	  <jsp:include page="/header.jsp"/>

	<h2>Thankyou, the book ${title} is now safely in the system.</h2> 
      
      <jsp:include page="/footer.jsp"/>
   </body>
</html>
