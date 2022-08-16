<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="message.globalPage.languageSetting.title" /></title>
</head>
<body>
<a href="/globalPage/topPage.do?lang=ko">한국어</a><br>
<a href="/globalPage/topPage.do?lange=jp">日本語</a>
</body>
</html>