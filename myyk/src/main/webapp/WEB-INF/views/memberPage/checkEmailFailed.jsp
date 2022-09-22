<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="message.memberPage.createMember.title" /></title>
<link href="/myyk/css/member.css" rel="stylesheet">
</head>
<%@ include file="/WEB-INF/views/header.jsp" %>
<body>
  
  <div class="content-body mb-3">
    <form action="/myyk/globalPage/homePage.do" class="text-center"> 
  	  <label for="create-member-upper-email" class="form-label h3 primary-dark-color-not-hover mt-4 mb-4"><spring:message code="message.memberPage.checkEmailFailed.message" /></label>
	
	  <div class="ok-btn-div">
  	    <button type="submit" class="btn btn-primary">Home</button>
  	  </div>
	</form>  
  </div>
</body>
<%@ include file="/WEB-INF/views/footer.jsp" %>
</html>