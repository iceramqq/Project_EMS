<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<script>
$(function() {
	$("#ems-write").click(function() {
		document.location.href = "${rootPath}/ems/write"
	})
	$(".ems_tr").click(function() {
		let id = $(this).data("id")
		document.location.href = "${rootPath}/ems/detail/" + id
	})
})
</script>
<style>
table {
	border-collapse: collapse;
	border-spacing: 0;
	width: 70%;
	border: 1px solid #aaa;
	margin: 30px auto;
}

table th, table td {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: center;
	vertical-align: top;
}

table td {
	cursor: pointer;
}

table tr:nth-child(even) {
	background-color: #f1f1f1;
}

table tr:nth-child(odd) {
	background-color: #fff;
}

table tr:nth-child(n+2):hover {
	background-color: #ccc;
}

tr.ems_tr {
	cursor: pointer;
}

tr.ems_tr:hover {
	background-color: #ccc;
}

div#btn-write {
	width: 70%;
	margin: 30px auto;
	text-align: right;
}

div#btn-write button {
	background-color: blue;
	padding: 10px;
	border: none;
	color: white;
	border-radius: 5px; 
}

div#btn-write button:hover {
	background-color: #ddd;
	color: black;
	box-shadow: 2px 2px 2px rgba(0,0,0,0.5);
}
</style>
<table>
	<thead>
		<tr>
			<th>NO</th>
			<th>작성일자</th>
			<th>작성시각</th>
			<th>발송 email</th>
			<th>받는 email</th>
			<th>제목</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${empty emsList}">
			<tr>
				<td colspan="6">데이터가 없습니다</td>
			</tr>
		</c:if>
		<c:forEach items="${emsList}" var="vo" varStatus="i">
			<tr class="ems_tr" data-id="${vo.id}">
				<td>${i.count}</td>
				<td>${vo.s_date}</td>
				<td>${vo.s_time}</td>
				<td>${vo.from_email}</td>
				<td>${vo.to_email}
				<td>${vo.s_subject}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div id="btn-write">
	<button id="ems-write">email 작성</button>
</div>