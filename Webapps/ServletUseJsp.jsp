<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<H2 ALIGN="CENTER"> Servlet is called by this JSP </H2>
<%
out.println(request.getAttribute("servletName"));
%>
</body>
</html>