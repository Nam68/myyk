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
  
    <form action="/myyk/memberPage/checkEmail.do" method="post">
    
  	  <label for="create-member-upper-email" class="form-label h3 primary-dark-color-not-hover"><spring:message code="message.memberPage.createMember.email" /></label>
      <div class="input-group mb-4">
	    <input id="create-member-upper-email" type="text" class="form-control" name="localPartEmail">
	    <span class="input-group-text">@</span>
	    <input type="text" class="form-control" name="domainPartEmail">
	  </div>
	  
	  <div class="ok-btn-div">
  	    <button type="submit" class="btn btn-primary">ok</button>
  	    <button type="button" class="btn btn-outline-primary">return</button>
  	  </div>
	  
    </form>
    
  </div>
</body>
<%@ include file="/WEB-INF/views/footer.jsp" %>
</html>