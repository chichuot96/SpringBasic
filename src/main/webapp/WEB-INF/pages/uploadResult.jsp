<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     
<html>
<head>
<meta charset="UTF-8">
<title>Upload Result</title>
</head>
<body>
    
    <h3>Uploaded Files:</h3>
     
    Description: ${description}
     
    <br/>
     
    <c:forEach items="${uploadedFiles}" var="file">
           - ${file} <br>
    </c:forEach>
 
</body>
</html>