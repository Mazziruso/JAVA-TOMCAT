<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Declaration</title>
</head>
<body>
	<%! 
		int accessCount = 0;
	%>
	<%
		int accessCount2 = 0;
	%>
	<H2>
		Accesses to pages since server reboot:
		<%= ++accessCount %>
		<br>
		<%= ++accessCount2 %>
	</H2>
</body>
</html>