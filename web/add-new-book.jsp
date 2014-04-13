<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
   <head>
   	<title>Enter a new book</title>
   	<link href="<c:url value="/styles.css"/>" rel="Stylesheet" type="text/css"/>   
   </head>

   <body>
	  <jsp:include page="/header.jsp"/>


	  <div id="addBook">
		  <form:form commandName="book">
	         <label>Enter ISBN</label><form:input path="isbn"/>	  
	                                  <form:errors path="isbn" cssClass="error"/>  
	                    
	         <label>Enter Title</label> <form:input path="title"/>
	         		                    <form:errors path="title" cssClass="error"/>  
	         	
	         <label>Enter Author</label><form:input path="author"/>
	         		                    <form:errors path="author" cssClass="error"/>  
	         	
	         <label>Enter Price</label><form:input path="price"/>	               
	         	                       <form:errors path="price" cssClass="error"/>  
	         
	
	         <input type="submit" value="Add New Book"/>
	      </form:form>		   	  
      </div>
            
      <jsp:include page="/footer.jsp"/>
   </body>
</html>
