<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload One File</title>
</head>
<body>
     
    <h3>Upload One File:</h3>
 
    <!-- MyUploadForm -->
    <form:form modelAttribute="myUploadForm" method="POST"
                    action="" enctype="multipart/form-data">
 
        Description:
        <br>
        <form:input path="description" style="width:300px;"/>                
        <br/><br/>  
             
        File to upload: <form:input path="fileDatas" type="file" name="file"/><br />  
         
           
        <input type="submit" value="Upload">
         
    </form:form>
     <table border="1">
        <tr>
            <td> Name:</td>
			<td> date of birth </td>
        </tr>
     <c:forEach items="${list }" var="student">
     	<tr>
     		<td>${student.name }</td>
     		<td>${student.dateOfBirth }</td>
     		</tr>
     </c:forEach>
     </table>
</body>
 
</html>