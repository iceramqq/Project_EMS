<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<script>
	// 화면에 Content가 모두 loading 되면
	document.addEventListener("DOMContentLoaded",function(){
		// id가 nav-bbs인 tag에 click이벤트 설정
		document.querySelector("#nav-home").addEventListener("click",function(){
			document.location.href="${rootPath}/"
		})
		document.querySelector("#nav-email").addEventListener("click",function(){
			document.location.href="${rootPath}/ems/list"
		})
	})
	
</script>  
<nav>
	<ul>
		<li id="nav-home">Home</li>
		<li id="nav-email">email</li>
	</ul>
</nav>