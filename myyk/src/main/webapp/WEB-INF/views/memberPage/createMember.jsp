<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="message.memberPage.createMember.title" /></title>
<link href="/myyk/css/member.css" rel="stylesheet">
</head>
<%@ include file="/WEB-INF/views/header.jsp" %>
<body>
  
  <div class="title mx-auto"><spring:message code="message.memberPage.createMember.title" /></div>

  <div class="content-body">
    <form action="/myyk/memberPage/createMember.do" method="post">
    
      <label for="create-member-upper-email" class="form-label h3 primary-dark-color-not-hover"><spring:message code="message.memberPage.createMember.email" /></label>
      <div class="input-group mb-4">
	    <input id="create-member-upper-email" type="text" class="form-control" name="upperEmail">
	    <span class="input-group-text">@</span>
	    <input type="text" class="form-control" name="lowerEmail">
	  </div>
  
  	  <label for="create-member-password" class="form-label h3 primary-dark-color"><spring:message code="message.memberPage.createMember.password" /></label>
  	  <input id="create-member-password" type="password" class="form-control mb-4" name="password">
  	  
  	  <label for="create-member-password-check" class="form-label h3 primary-dark-color"><spring:message code="message.memberPage.createMember.passwordCheck" /></label>
  	  <input id="create-member-password-ckeck" type="password" class="form-control mb-4" name="password">
  	  
  	  <label for="create-member-nickname" class="form-label h3 primary-dark-color"><spring:message code="message.memberPage.createMember.nickname" /></label>
  	  <input id="create-member-nickname" type="password" class="form-control mb-4" name="password">
  	  
  	  <label for="create-member-region" class="form-label h3 primary-dark-color"><spring:message code="message.memberPage.createMember.region" /></label>
  	  <select id="create-member-region" class="form-select mb-4" name="region">
		<c:forEach var="r" items="${enums.region }">
		  <option value="${r.name }"><spring:message code="message.enum.region.${r.value }" /></option>
		</c:forEach>
	  </select>
  	  
  	  <div class="ok-btn-div">
  	    <button type="button" class="btn btn-primary">ok</button>
  	    <button type="button" class="btn btn-outline-primary">return</button>
  	  </div>
  	  
    </form>
  </div>
	
</body>
<%@ include file="/WEB-INF/views/footer.jsp" %>
</html>