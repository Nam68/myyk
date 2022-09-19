<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/links.jsp" %>
<link href="/myyk/css/globalCss.css" rel="stylesheet">
<link href="/myyk/css/header.css" rel="stylesheet">

    <header class="fixed-top d-flex flex-wrap mx-4 align-items-center justify-content-center justify-content-md-between border-bottom">
      <a href="/" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
        <svg class="bi d-block mx-auto mb-1" width="24" height="24"><use xlink:href="#bootstrap"/></svg>
      </a>
      <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0 text-center">
        <li><a href="#" class="nav-link px-2 me-2 ${headerValue == 'HOME' ? 'text-primary' : 'primary-dark-color'}"><svg class="bi d-block mx-auto mb-1"><use xlink:href="#home"/></svg>Home</a></li>
        <li><a href="#" class="nav-link px-2 me-2 ${headerValue == 'MEMORY' ? 'text-primary' : 'primary-dark-color'}"><svg class="bi d-block mx-auto mb-1"><use xlink:href="#memory"/></svg>Memory</a></li>
        <li><a href="#" class="nav-link px-2 me-2 ${headerValue == 'WISH_PLACE' ? 'text-primary' : 'primary-dark-color'}"><svg class="bi d-block mx-auto mb-1"><use xlink:href="#wish-place"/></svg>Wish Place</a></li>
        <li><a href="#" class="nav-link px-2 me-2 ${headerValue == 'MAP' ? 'text-primary' : 'primary-dark-color'}"><svg class="bi d-block mx-auto mb-1"><use xlink:href="#map"/></svg>Map</a></li>
        <li><a href="#" class="nav-link px-2 ${headerValue == 'REQUEST' ? 'text-primary' : 'primary-dark-color'}"><svg class="bi d-block mx-auto mb-1"><use xlink:href="#request"/></svg>Request</a></li>
      </ul>
      <div id="login-btn-div" class="text-end">
        <button type="button" class="btn btn-outline-primary me-2" href="">Login</button>
        <button type="button" class="btn btn-primary" href="">Sign-up</button>
      </div>
    </header>