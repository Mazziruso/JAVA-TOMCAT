<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BGColor</title>
</head>
<%
String bgColor = request.getParameter("bgColor");
boolean hasColor = false;
if(bgColor != null) {
	hasColor = true;
} else {
	hasColor = false;
	bgColor = "WHITE";
}
%>
<body BGCOLOR="<%= bgColor %>">
<H2 ALIGN="CENTER">Color Testing</H2>
<H2 ALIGN="CENTER">
<%
if(hasColor) {
	out.println("Your Color: " + bgColor);
} else {
	out.println("Default Color: white");
}
%>
</H2>
<H1>sda: <%="das" %></H1>
<H1>sda: <% out.println("das"); %></H1>
</body>
</html>