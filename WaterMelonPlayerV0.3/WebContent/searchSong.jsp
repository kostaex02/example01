<%@page import="watermelon.dto.Song"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Song</title>
<!-- Bootstrap core CSS -->
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="css/jumbotron.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<script src="bootstrap/js/jquery-2.2.4.js"></script>
<script type="text/javascript">
$(function() {
	$("#myPage").click(function() {
		location.href="myPage";
	})
	$("#logout").click(function() {
		 var form = document.createElement("form");
		    form.setAttribute("method", "post");
		    form.setAttribute("action", "logout");
		    document.body.appendChild(form);
		    form.submit();
	})
	$("#song1").click(function() {
		$("#select").val("song");
	})
	$("#album1").click(function() {
		$("#select").val("album");
	})
	$("#artist1").click(function() {
		$("#select").val("artist");
	})
})
</script>
<body>
	<nav class="navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"> <img alt="Brand"
					src="img/waterMelon.png" width="130px" style="margin-top: -7px">
				</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse"
				style="margin-left: 27%">
				<form class="navbar-form" action="select">
					<div class="col">
						<div class="col-lg-4">
							<div class="input-group" align="right"
								style="margin-right: -11px">
								<div class="input-group-btn">
									<button type="button" class="btn btn-default dropdown-toggle"
										data-toggle="dropdown" aria-expanded="false">
										곡명<span class="caret"></span>
									</button>
									<input type="hidden" id="select" name="select" value="song" />
									<ul class="dropdown-menu" role="menu">
										<li><a href="#" id="song1">곡명</a></li>
										<li><a href="#" id="album1">앨범</a></li>
										<li><a href="#" id="artist1">아티스트</a></li>
									</ul>
								</div>
								<!-- /btn-group -->
								<input type="text" class="form-control" aria-label="..." id="content" name="content">
							</div>
							<!-- /input-group -->
						</div>
						<!-- /.col-lg-4 -->
					</div>
					<button type="submit" class="btn btn-success">검색</button>
					<div style="display: inline;">
						<span class="form-group" style="color: red; margin-left: 32mm">${User.userName}님
							환영합니다.</span> 
							<input type="button" class="btn btn-info btn-sm" value="로그아웃" id="logout" style="margin-left: 5px">
                    		<input type="button" class="btn btn-info btn-sm" value="마이페이지" id="myPage" style="margin-right: 10px">
                    
					</div>
				</form>
			</div>

			<!-- /.nav-collapse -->
		</div>
	</nav>

	<div class="container" style="margin-right: 120px; margin-left: 120px">
		<h1 class="page-header" style="margin: 80px 20px 50px">song 검색 결과</h1>

		<h2 class="sub-header" style="margin: 80px 20px 20px">곡</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<%
					int i = 0;
				%>
				<h3 style="margin: 20mm 20px 20px; display: inline-table; margin-right: 0px; font-size: 21px">곡</h3>
				<span class="badge" style="background-color: green; font-size: medium;"><%=++i%></span>
				<hr style="border-color: green">
				<thead>
				</thead>
				<tr>
					<td></td>
					<td>no</td>
					<td></td>
					<td>곡이름</td>
					<td>아티스트</td>
					<td>앨범</td>

				</tr>
				<c:forEach var="song" items="${list}">
					<td class="col-lg-0"><label data-pg-collapsed> <input
							class="control-label" type="checkbox" value=""></label></td>
					<td class="col-lg-0"><%=i%></td>
					<td class="col-lg-2"><a href="#" class="btn primary"
						id="btn_play"> <img src="img/img_play_before.png"
							class="pull-left" height="25px" /></a> <a href="#"
						class="btn primary" id="btn_play"> <img
							src="img/img_add_before.png" class="pull-left" height="25px" />
					</a></td>
					<td class="col-lg-3">${song.songName}
					<c:choose>
					<c:when test="${song.songTitle==1}"><span class="label label-danger">TITLE</span></td></c:when>
					<c:otherwise></c:otherwise>
					</c:choose>					
					<td class="col-lg-5">${song.aristName}</td>
					<td class="col-lg-9">${song.albumName}</td>

				</c:forEach>
			</table>
		</div>
	</div>

	<!-- /container -->
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="bootstrap/js/jquery-2.2.4.js"></script>
	<script src="bootstrap/js/bootstrap.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script>
		$(document).ready(function() {
			$('[data-toggle="test"]').click(function() {
				$('.row-test').toggleClass('active')
			});
		});
	</script>
</body>
</html>