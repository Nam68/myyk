<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="message.memberPage.createMember.title" /></title>
</head>
<body>
createMember<br>
<form action="/myyk/memberPage/createMember.do" method="post">
<spring:message code="message.memberPage.createMember.email" /><br>
<input name="upperEmail" type="text">@
<input name="lowerEmail" type="text">
<br>
<spring:message code="message.memberPage.createMember.password" /><br>
<input name="password" type="password">
<br>
<spring:message code="message.memberPage.createMember.passwordCheck" /><br>
<input name="passwordCheck" type="password">
<br>
<spring:message code="message.memberPage.createMember.nickname" /><br>
<input name="nickname" type="text">
<br>
<spring:message code="message.memberPage.createMember.region" /><br>
<input name="region" type="text">
<br>
<button type="submit">ok</button>
</form>
</body>
</html>