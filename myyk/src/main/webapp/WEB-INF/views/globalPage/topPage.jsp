<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
hello world!
${requestScope.header }
${sessionScope.period }<br>
<a href="/myyk/globalPage/homePage.do">next</a>
<a href="/myyk/globalPage/skipTopPage.do?value=true">not show</a>
</body>
</html>