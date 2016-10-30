<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>detailAlbum</title>
<!-- Bootstrap core CSS -->
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="css/jumbotron.css" rel="stylesheet">
<script src="bootstrap/js/jquery-2.2.4.js"></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<style>
#btn_play {
	padding: 0px 0px;
	border: 0px;
}

label {
	margin-bottom: 0px;
}
</style>
<script>
	$(function() {
		$("#myPage").click(function() {
			location.href = "myPage";
		})
		$("#logout").click(function() {
			var form = document.createElement("form");
			form.setAttribute("method", "post");
			form.setAttribute("action", "logout");
			document.body.appendChild(form);
			form.submit();
		})
		$("#btnRegister").click(function() {
			$.ajax({
				url : "ReviewInsert",
				type : "post",
				data : "contents=" + $("#contents").val(),
				dataType : "text",
				success : function(result) {
					if (result > 0) {
						//모든 텍스트박스를 지운다.
						alert("성공!");
						$("textArea").val("");
						//모든 레코드 검색
						selectReviewAll();
					} else {
						alert("실패");
					}
				}
			})
		})

		$(document).on("click", "#btnDelete", function() {

			$.ajax({
				url : "ReviewDelete",
				type : "post",
				data : "no=" + $(this).attr("name"),
				dataType : "text",
				success : function(result) {
					if (result > 0) {
						alert("삭제성공");
						selectReviewAll();
					} else {
						alert("삭제실패");
					}
				},
				error : function() {

				}
			})
		})

		function selectReviewAll() {
			$
					.ajax({
						url : "ReviewSelect",
						type : "post",
						dataType : "json",
						success : function(result) {
							var str = "";
							$("#contentsTable tr:gt(0)").remove();
							$
									.each(
											result,
											function(index, item) {
												str += "<tr>";
												str += "<td id='reviewId'>"
														+ item.reviewId
														+ "</td>";
												str += "<td id='reviewContents'>"
														+ item.reviewContents
														+ "</td>";
												str += "<td><button type='button' class='btn btn-default btn-xs' id='btnDelete' name="+item.reviewNo + " value="+item.reviewId+">삭제</button></td>"
												str += "</tr>";
											})
							$("#contentsTable tr:eq(0)").after(str);
						},
						error : function(result) {

						}
					});
		}
		selectReviewAll();
	})
</script>
</head>
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
			<span id="navbar" class="navbar-collapse collapse"
				style="padding-left: 24%">
				<form class="navbar-form">
					<div class="col">
						<div class="col-lg-4">
							<div class="input-group">
								<div class="input-group-btn">
									<button type="button" class="btn btn-default dropdown-toggle"
										data-toggle="dropdown" aria-expanded="false">
										곡명<span class="caret"></span>
									</button>
									<ul class="dropdown-menu" role="menu">
										<li><a href="#">곡명</a></li>
										<li><a href="#">앨범</a></li>
										<li><a href="#">아티스트</a></li>
									</ul>
								</div>
								<!-- /btn-group -->
								<input type="text" class="form-control" aria-label="...">
							</div>
							<!-- /input-group -->
						</div>
						<!-- /.col-lg-4 -->
					</div>
					<button type="submit" class="btn btn-success">검색</button>


					<span class="form-group" style="color: red; margin-left: 14%">${User.userName}님
						환영합니다.</span> <input type="button" class="btn btn-info btn-sm"
						value="로그아웃" id="logout" style="margin-left: 5px"> <input
						type="button" class="btn btn-info btn-sm" value="마이페이지"
						id="myPage" style="margin-right: 10px">
				</form>
			</span>

			<!-- /.nav-collapse -->
		</div>
	</nav>
	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="container">
		<div class="row row-offcanvas ">
			<div class="col-xs-12 col-sm-9">
				<div class="row">
					<!-- 행 -->
					<div class="col-xs-6 col-lg-4"
						style="margin-top: 50px; outline-style: none;">
						<!-- 열 -->
						<img src="${albumImgUrl}" style="margin: 0px">
					</div>
					<div class="col-xs-6 col-lg-8"
						style="margin-top: 50px; outline-style: none;">
						<h2 class="text-left">${albumName}</h2>
						<h3 class="text-left">아티스트 : ${albumArtist}</h3>
						<h3 class="text-left">장르&nbsp; &nbsp; &nbsp; &nbsp; : ${genre}</h3>
					</div>
					<!--/.col-xs-6.col-lg-4-->
				</div>
				
				
				<br> 
				<%
				int i =0;
				%>
				수록곡 <span class="badge" style="background-color: green"><%=++i%></span>
				<hr style="border-color: green">
				<div class="row">
					<table class="table table-striped">
						<thead>
							<tr>
								<th></th>
								<th>No</th>
								<th></th>
								<th>곡명</th>
								<th>아티스트</th>
								<th>앨범</th>
							</tr>
						</thead>
						<tbody>
				<c:forEach var="song" items="${SongList }">
					<tr>
						<td class="col-lg-0"><label data-pg-collapsed><input class="control-label" type="checkbox" value=""></label></td>
						<td class="col-lg-0"><%=i%></td>		
						<td class="col-lg-2"><a href="#" class="btn primary" id="btn_play"> <img src="img/img_play_before.png" class="pull-left" height="25px" /></a><a href="#" class="btn primary" id="btn_play"> <img
										src="img/img_add_before.png" class="pull-left" height="25px" />
								</a></td>
								<td class="col-lg-3">${song.songName}&nbsp;
								<c:choose>
									<c:when test="${song.songTitle==1}"><span class="label label-danger">TITLE</span></td></c:when>
									<c:otherwise></td></c:otherwise>
								</c:choose>		
								<td class="col-lg-8">${song.aristName }</td>
								<td class="col-lg-9">${song.albumName}</td>
							</tr>
				</c:forEach>
						</tbody>
					</table>
				</div>
				<hr style="border-color: green">
				<h3>앨범소개</h3>
				<hr>
				<h6>${albumContents}</h6>
				<hr style="border-color: green">
				<h3>리뷰</h3>
				<form name="contentsForm" method="post" id="contentsForm">

					<div class="col-xs-5 col-lg-8" style="outline-style: none;">
						<textarea class="form-control" rows="2" style="margin-left: 10px"
							id="contents"></textarea>
					</div>
					<div class="col-xs-7 col-lg-4" style="outline-style: none;">
						<button type="button" class="btn btn-primary btn-lg"
							style="padding: 12px 12px; margin-left: -10px" id="btnRegister">등록</button>
					</div>
				</form>
			</div>
			
			
			
			
			<div class="col-xs-12 col-sm-9">

				<table class="table table-striped" id="contentsTable">
					<tbody>
						<tr>
							<td class="col-lg-1" align="center">ID</td>
							<td class="col-lg-9" align="center">Contents</td>
							<td class="col-lg-2"></td>
						</tr>

					</tbody>
				</table>
			</div>

		</div>
		<hr>
		<footer>
			<p>&copy; OneTeam</p>
		</footer>
	</div>
	<!-- /container -->
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

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
