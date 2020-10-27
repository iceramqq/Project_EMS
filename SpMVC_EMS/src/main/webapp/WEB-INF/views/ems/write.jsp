<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<style>
form#write-form {
	width: 80%;
	margin: 10px auto;
}

form#write-form fieldset {
	border: 2px solid blue;
	border-radius: 10px;
}

form#write-form legend {
	color: blue;
	margin: 10px;
	padding: 5px;
}

form#write-form label {
	display: inline-block;
	width: 20%;
	padding: 4px;
	margin: 4px;
	color: blue;
	text-align: right;
	font-weight: bold;
}

form#write-form input {
	display: inline-block;
	width: 70%;
	padding: 4px;
	margin: 4px;
}

form#write-form textarea {
	width: 70%;
}

div.button-box {
	text-align: right;
}

form#write-form .button-box button {
	color: white;
	cursor: pointer;
	outline: 0;
	border: 0;
	padding: 10px 16px;
	margin: 5px;
	border-radius: 5px;
}

button:hover {
	box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.5);
}

button#list {
	background-color: green;
}

button#save {
	background-color: blue;
}
</style>
<script>
	$(function() {
		var toolbar = [ [ 'style', [ 'bold', 'italic', 'underline' ] ],
				[ 'fontsize', [ 'fontsize' ] ],
				[ 'font Style', [ 'fontname' ] ], [ 'color', [ 'color' ] ],
				[ 'para', [ 'ul', 'ol', 'paragraph' ] ],
				[ 'height', [ 'height' ] ], [ 'table', [ 'table' ] ],
				[ 'insert', [ 'link', 'hr', 'picture' ] ],
				[ 'view', [ 'fullscreen', 'codeview' ] ]

		]

		$("#s_content").summernote({
			lang : "ko-KR",
			width : "100%",
			height : "200px",
			toolbar : toolbar
		});
	})
</script>
<script type="text/javascript">
	document.addEventListener("DOMContentLoaded", function() {
		document.querySelector("#list").addEventListener("click", function() {
			document.location.href = "${rootPath}/ems/list"
		})
	})
</script>
<form id="write-form" method="POST" enctype="mulipart/form-data">
	<fieldset>
		<legend>email 작성</legend>
		<div>
			<label>발송 email</label> <input name="from_email">
		</div>
		<div>
			<label>받는 email</label> <input name="to_email">
		</div>
		<div>
			<label>발송일자</label> <input name="s_date">
		</div>
		<div>
			<label>발송시각</label> <input name="s_time">
		</div>
		<div>
			<label>제목</label> <input name="s_subject">
		</div>
		<div>
			<label></label>
			<textarea id="s_content" 
					rows="5" cols="20" 
					name="s_content"></textarea>
		</div>
		<div>
			<label>첨부파일1</label>
			<input type="file" name="file1">
		</div>
		<div>
			<label>첨부파일2</label>
			<input type="file" name="file2">
		</div>
		<div class="button-box">
			<button type="button" id="list">리스트</button>
			<button type="submit" id="save">저장</button>
		</div>
	</fieldset>
</form>