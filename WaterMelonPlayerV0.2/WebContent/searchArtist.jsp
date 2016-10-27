<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Artist</title>
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
				<form class="navbar-form">
					<div class="col">
						<div class="col-lg-4">
							<div class="input-group" align="left" style="margin-right: -11px">
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
					<div style="display: inline;">
						<span class="form-group" style="color: red; margin-left: 32mm">김김김님
							환영합니다.</span> <input type="button" class="btn btn-info btn-sm"
							value="회원정보변경" style="margin-left: 5px"> <input
							type="button" class="btn btn-info btn-sm" value="로그아웃"
							style="margin-right: 10px">
					</div>
				</form>
			</div>

			<!-- /.nav-collapse -->
		</div>
	</nav>

	<div class="container">
		<h5 class="page-header" style="margin: 60px 20px 40px">'artist'에
			대한 검색 결과입니다.</h5>
		<div class="row placeholders">
			<div class="col-xs-6 col-lg-4">
				<img src="img/1989.png" style="margin-left: 21px">
			</div>
			<div class="col-xs-6 col-lg-8"
				style="margin-top: -5px; outline-style: none">
				<h3 class="text-left" style="color: #818181; display: inline-block">앨범</h3>
				<span id="artist">스위티 오</span><br>
				<h3 class="text-left" style="color: #818181; display: inline-block">아티스트</h3>
				<span id="artist">테일러 스위프트</span><br>
				<h3 class="text-left" style="color: #818181; display: inline-block">발매일</h3>
				<span id="artist">2016-10-27</span><br>
				<h3 class="text-left" style="color: #818181; display: inline-block">장르</h3>
				<span id="artist">댄스/발라드</span><br>
			</div>
		</div>
		<h3
			style="margin: 20mm 20px 20px; display: inline-table; margin-right: 0px; font-size: 21px">곡</h3>
		<span class="badge"
			style="background-color: green; font-size: medium;">3</span>
		<hr style="border-color: green">
		<!--/row-->
		<div class="row" style="margin: 0 5px 0">
			<table class="table table-striped" style="border-color: green">
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
					<tr>
						<td class="col-lg-0">
							<label data-pg-collapsed> 
							<input class="control-label" type="checkbox" value="">
							</label>
						</td>
						<td class="col-lg-0">1</td>
						<td class="col-lg-2">
							<a href="#" class="btn primary"	id="btn_play"> 
								<img src="img/img_play_before.png" class="pull-left" height="25px" />
							</a> 
							<a href="#" class="btn primary" id="btn_play"> 
								<img src="img/img_add_before.png" class="pull-left" height="25px" />
							</a>
						</td>
						<td class="col-lg-3">ipsum&nbsp;<span class="label label-danger">TITLE</span></td>
						<td class="col-lg-5">ipsum</td>
						<td class="col-lg-9">dolor</td>
					</tr>
					<tr>
						<td></td>
						<td>No</td>
						<td></td>
						<td>곡명</td>
						<td>아티스트</td>
						<td>앨범</td>
					</tr>
					<tr>
						<td></td>
						<td>No</td>
						<td></td>
						<td>곡명</td>
						<td>아티스트</td>
						<td>앨범</td>
					</tr>
					<tr>
						<td></td>
						<td>No</td>
						<td></td>
						<td>곡명</td>
						<td>아티스트</td>
						<td>앨범</td>
					</tr>
					<tr>
						<td></td>
						<td>No</td>
						<td></td>
						<td>곡명</td>
						<td>아티스트</td>
						<td>앨범</td>
					</tr>
					
				</tbody>
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