<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="message.globalPage.topPage.title" /></title>
</head>
<body>
hello world!<br>
${requestScope.header }<br>
${sessionScope.period }<br>
<a href="/myyk/globalPage/homePage.do">next</a>
<a href="/myyk/globalPage/skipTopPage.do?value=true">not show</a>
</body>
</html>