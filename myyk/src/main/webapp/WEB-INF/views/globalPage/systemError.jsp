<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="message.error.global.title" /></title>
<style>
.title {
	border-bottom: 0px black solid!important;
}
</style>
</head>
<%@ include file="/WEB-INF/views/header.jsp" %>
<body>
<div class="title mx-auto mt-5"><spring:message code="message.error.global.title" /></div>
<div class="primary-dark-color-not-hover h2 mb-4"><spring:message code="message.error.global.toAdmin" /></div>
<div class="primary-color-not-hover h4 mt-4"><spring:message code="message.error.global.error" />${messages }</div>
</body>
<%@ include file="/WEB-INF/views/footer.jsp" %>
</html>