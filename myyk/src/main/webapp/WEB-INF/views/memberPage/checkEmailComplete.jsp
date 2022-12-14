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
  
  <div class="title mx-auto"><spring:message code="message.memberPage.checkEmail.title" /></div>

  <div class="content-body mb-3">
    
  	  <label for="create-member-upper-email" class="form-label h3 primary-dark-color-not-hover"><spring:message code="message.memberPage.checkEmailComplete.sendEmail" /></label>
	  
	  <div class="ok-btn-div">
  	    <button type="submit" class="btn btn-outline-primary">Return</button>
  	  </div>
	  
  </div>
</body>
<script>
$('button[type=submit]').on('click', function(e) {
	location.href='/myyk/memberPage/checkEmailInput.do';
});
</script>
<%@ include file="/WEB-INF/views/footer.jsp" %>
</html>