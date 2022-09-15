<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="message.memberPage.createMember.title" /></title>
</head>
<%@ include file="/WEB-INF/views/header.jsp" %>
<body>
createMember<br>
<form action="/myyk/memberPage/createMember.do" method="post">
<spring:message code="message.memberPage.createMember.email" /><br>
<input name="upperEmail" type="text">@
<input name="lowerEmail" type="text">
<button id="checkDuplicationMailBtn">dddd</button>
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
<select name="region">
	<c:forEach var="r" items="${enums.region }">
	<option value="${r.name }"><spring:message code="message.enum.region.${r.value }" /></option>
	</c:forEach>
</select>
<br>
<button type="submit">ok</button>
</form>
<script>
	
</script>
</body>
</html>