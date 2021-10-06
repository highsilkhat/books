<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reading Books</title>
  <!-- Bootstrap -->
  <link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
</head>
<body>
    <div class="container">
    
    <h1>All Books</h1>
    
    <table class="table table-striped">
    	<tr>
	    	<th>
	    	ID
	    	</th>
	    	
	    	<th>
	    	Title
	    	</th>
	    	
	    	<th>
	    	Description
	    	</th>
	    	
	    	<th>
	    	Language
	    	</th>
	    	
	    	<th>
	    	# of pages
	    	</th>
	    	
    	</tr>
    	
    	<tbody>
    	
    	<c:forEach var="book" items="${ books }">
    	<tr>
    		<td>
    		${ book.id }
    		</td>
    		
    		<td>
    		<a href="/books/${ book.id }">${ book.title }</a>
    		</td>
    		
    		<td>
    		
    		${ book.description }
    		
    		</td>
    		
    		<td>
    		${ book.language }
    		</td>
    		
    		<td>
    		${ book.numberOfPages }
    		</td>
    		
    	
    	
    	</c:forEach>
    	
    	
    	</tbody>
    
    
    
    
    
    
    
    </table>
    
        
    </div> 
</body>
</html>