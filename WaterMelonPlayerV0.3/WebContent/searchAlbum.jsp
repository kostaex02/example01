<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Album</title>
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
		location.href="logout";
	})
	$("#song").click(function() {
		$("#select").val("song");
	})
	$("#album").click(function() {
		$("#select").val("album");
	})
	$("#artist").click(function() {
		$("#select").val("artist");
	})
})
</script>
<body>
<nav class="navbar-inverse" >
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">
        				<img alt="Brand" src="img/waterMelon.png" width="130px" style="margin-top:-7px">
      				</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse" style="margin-left: 27%">
                    <form class="navbar-form" action="select">
                    <div class="col">
                       <div class="col-lg-4">
  						  <div class="input-group" align="right" style="margin-right: -11px">
    						<div class="input-group-btn">
     							<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">곡명<span class="caret"></span></button>
      								<input type="hidden" id="select" name="select" value="song" />
      								<ul class="dropdown-menu" role="menu">
							          <li><a href="#">곡명</a></li>
							          <li><a href="#">앨범</a></li>
							          <li><a href="#">아티스트</a></li>
							        </ul>
							</div><!-- /btn-group -->
								<input type="text" class="form-control" aria-label="...">
							</div><!-- /input-group -->
						</div><!-- /.col-lg-4 -->
					</div>
                        <button type="submit" class="btn btn-success">검색</button>
					<div style="display: inline;">
                        <span class="form-group" style="color:red; margin-left: 32mm">${User.userName}님 환영합니다.</span>
                        	<input type="button" class="btn btn-info btn-sm" value="회원정보변경" style="margin-left: 5px">
                            <input type="button" class="btn btn-info btn-sm" value="로그아웃" style="margin-right: 10px">
					</div>
                    </form>
                </div>
                
                <!-- /.nav-collapse -->
            </div>
        </nav>
<%-- <div class="container">
		<h5 class="page-header" style="margin: 60px 20px 40px">'artist'에
			대한 검색 결과입니다.</h5>
		<div class="row placeholders">
			<div class="col-xs-6 col-lg-4">
				<img src="img/1989.png" style="margin-left: 21px">
			</div>
			<div class="col-xs-6 col-lg-8"
				style="margin-top: -5px; outline-style: none">
				<h3 class="text-left" style="color: #818181; display: inline-block">아티스트</h3>
				<span id="artist"><%= %></span><br>
				<h3 class="text-left" style="color: #818181; display: inline-block">성별</h3>
				<span id="artist"><%= %></span><br>
				<h3 class="text-left" style="color: #818181; display: inline-block">그룹</h3>
				<span id="artist"><%= %></span><br>
			</div>
		</div> --%>
<div class="container" style="margin-right:120px; margin-left:120px">
    <h1 class="page-header" style="margin: 80px 20px 50px">album 검색 결과</h1>
    <div class="row placeholders">
		<div class="row placeholders">
			<div class="col-xs-6 col-lg-4">
				<img src="img/1989.png" style="margin-left: 21px">
			</div>
			<div class="col-xs-6 col-lg-8"
				style="margin-top: -5px; outline-style: none">
				<h3 class="text-left" style="color: #818181; display: inline-block">아티스트</h3>
				<span id="artist">ㅇㅇ</span><br>
				<h3 class="text-left" style="color: #818181; display: inline-block">성별</h3>
				<span id="artist">ㅇㅇ</span><br>
				<h3 class="text-left" style="color: #818181; display: inline-block">그룹</h3>
				<span id="artist">ㅇㅇ</span><br>
			</div>
		</div>
		<br>
    	<p>
    	<br>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>버튼</th>
						<th>#</th>
						<th>곡명</th>
						<th>아티스트</th>
						<th>앨범</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>ㅁ</th>
						<td>1,001</td>
						<td>Lorem</td>
						<td>ipsum</td>
						<td>dolor</td>
					</tr>
					<tr>
						<th>ㅁ</th>
						<td>1,002</td>
						<td>amet</td>
						<td>consectetur</td>
						<td>adipiscing</td>
					</tr>
					<tr>
						<th>ㅁ</th>
						<td>1,003</td>
						<td>Integer</td>
						<td>nec</td>
						<td>odio</td>
					</tr>
					<tr>
						<th>ㅁ</th>
						<td>1,003</td>
						<td>libero</td>
						<td>Sed</td>
						<td>cursus</td>
					</tr>
					<tr>
						<th>ㅁ</th>
						<td>1,004</td>
						<td>dapibus</td>
						<td>diam</td>
						<td>Sed</td>
					</tr>
					<tr>
						<th>ㅁ</th>
						<td>1,005</td>
						<td>Nulla</td>
						<td>quis</td>
						<td>sem</td>
					</tr>
					<tr>
						<th>ㅁ</th>
						<td>1,006</td>
						<td>nibh</td>
						<td>elementum</td>
						<td>imperdiet</td>
					</tr>
					<tr>
						<th>ㅁ</th>
						<td>1,007</td>
						<td>sagittis</td>
						<td>ipsum</td>
						<td>Praesent</td>
					</tr>
					<tr>
						<th>ㅁ</th>
						<td>1,008</td>
						<td>Fusce</td>
						<td>nec</td>
						<td>tellus</td>
					</tr>
					<tr>
						<th>ㅁ</th>
						<td>1,009</td>
						<td>augue</td>
						<td>semper</td>
						<td>porta</td>
					</tr>
					<tr>
						<th>ㅁ</th>
						<td>1,010</td>
						<td>massa</td>
						<td>Vestibulum</td>
						<td>lacinia</td>
					</tr>
					<tr>
						<th>ㅁ</th>
						<td>1,011</td>
						<td>eget</td>
						<td>nulla</td>
						<td>Class</td>
					</tr>
					<tr>
						<th>ㅁ</th>
						<td>1,012</td>
						<td>taciti</td>
						<td>sociosqu</td>
						<td>ad</td>
					</tr>
					<tr>
						<th>ㅁ</th>
						<td>1,013</td>
						<td>torquent</td>
						<td>per</td>
						<td>conubia</td>
					</tr>
					<tr>
						<th>ㅁ</th>
						<td>1,014</td>
						<td>per</td>
						<td>inceptos</td>
						<td>himenaeos</td>
					</tr>
					<tr>
						<th>ㅁ</th>
						<td>1,015</td>
						<td>sodales</td>
						<td>ligula</td>
						<td>in</td>
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
        $(document).ready(function () {
            $('[data-toggle="test"]').click(function () {
                $('.row-test').toggleClass('active')
            });
        });
    </script>
</body>
</html>