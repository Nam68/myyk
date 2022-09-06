<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="message.globalPage.homePage.title" /></title>
</head>
<body>
<spring:message code="message.globalPage.homePage.title" /><br>
<a href="/myyk/globalPage/languageSettingPage.do">language setting</a><br>
<a href="/myyk/memberPage/createMemberInput.do">sign up</a>
</body>
</html>