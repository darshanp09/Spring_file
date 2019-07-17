<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload Page</title>
</head>
<body>
<spring:url value="/upload" var="uploadURL"/>
<form:form modelAttribute="fileUpload" method="POST" action="${uploadURL }" enctype="multipart/form-data">
	<form:input path="files" type="file" multiple="multiple"/>
	<form:errors path="files" cssStyle="color:red;"/>
	
	 <input type="submit" value="submit"">
</form:form>
</body>
</html>