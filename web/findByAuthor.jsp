<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
	<title>Find By Author</title>
	<link href="<c:url value="/styles.css"/>" rel="Stylesheet" type="text/css"/>
</head>
  
<body>

	<jsp:include page="/header.jsp"/>

    <div id="addBook">
	
		<h1>Which Author's Books?</h1>
		
		<c:out value="${message}"/>
		
		<form method="GET" ACTION="findByAuthor.do">
			<label>Required Author:</label><input type="TEXT" NAME="AUTHOR"/>
			<p><input type="SUBMIT" value="Find"/></p>
		</form>
		
	</div>
	
	<jsp:include page="/footer.jsp"/>
				
	</body>
</html>