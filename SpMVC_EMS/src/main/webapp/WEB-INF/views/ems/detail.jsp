<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<style>
table {
	border: 2px solid blue;
	width: 70%;
	margin: 10px auto;
	padding: 20px;
}

th {
	display: inline-block;
	width: 15%;
	text-align: right;
	padding: 8px;
	margin: 5px;
}

td {
	display: inline-block;
	width: 70%;
	border: 1px solid #ccc;
	border-radius:5px;
	padding: 8px;
	text-align: left;
	margin: 10px;
}

td#content {
	height: 100px;
}

section#button-box {
	width: 70%;
	margin: 10px auto;
	text-align: right;
}

section#button-box button {
	padding: 8px 16px;
	color: white;
	border-style: none;
	font-weight: bold;
}

section#button-box button:nth-child(1) {
	background-color: blue;
}

section#button-box button:nth-child(2) {
	background-color: green;
}

section#button-box button:nth-child(3) {
	background-color: orange;
}

section#button-box button:hover {
	background-color: #aaa;
	color: black;
}
</style>
<script type="text/javascript">
	document.addEventListener("DOMContentLoaded", function() {
		document.querySelector("section#button-box").addEventListener("click",
				function(e) {
					let url = "${rootPath}/ems/${emsVO.id}/"
					if (e.target.tagName === ("BUTTON")) {
						if (e.target.className == "delete") {
							alert("정말삭제 할까요?");
						}
						document.location.href = url + e.target.className
					}
				})
	})
</script>
<table>
	<tr>
		<th>id</th>
		<td>${emsVO.id}</td>
	</tr>
	<tr>
		<th>발송Email</th>
		<td>${emsVO.from_email}</td>
	</tr>
	<tr>
		<th>받는Email</th>
		<td>${emsVO.to_email}</td>
	</tr>
	<tr>
		<th>발송일자</th>
		<td>${emsVO.s_date}</td>
	</tr>
	<tr>
		<th>발송시각</th>
		<td>${emsVO.s_time}</td>
	</tr>
	<tr>
		<th>메일제목</th>
		<td>${emsVO.s_subject}</td>
	</tr>
	<tr>
		<th>메일내용</th>
		<td id="content">${emsVO.s_content}</td>
	</tr>
	<tr>
		<th>첨부파일1</th>
		<td>${emsVO.s_file1}</td>
	</tr>
	<tr>
		<th>첨부파일2</th>
		<td>${emsVO.s_file2}</td>
	</tr>
</table>
<section id="button-box">
	<button class="list">리스트</button>
	<button class="update">수정</button>
	<button class="delete">삭제</button>
</section>