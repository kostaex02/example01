<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript"
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css"
	rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-offset-3 col-md-6">
					<form role="form">
						<div class="form-group">
							<div class="input-group">
								<img src="<%= %>" class="center-block hidden-md img-rounded"> 
								<input type="text" class="form-control" placeholder="Enter your email">
								<span class="input-group-btn"> <a class="btn btn-success"
									type="submit">Go</a>
								</span>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<form class="form-horizontal" role="form">

						<div class="form-group">
							<div class="col-sm-2">
								<label for="inputPassword3" class="control-label">현재
									비밀번호</label>
							</div>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="Pwd"
									placeholder="현재 비밀번호">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-2">
								<label for="inputPassword3" class="control-label">새 비밀번호</label>
							</div>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="NewPwd"
									placeholder="새 비밀번호">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-2">
								<label for="inputPassword3" class="control-label">비밀번호
									확인</label>
							</div>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="RePwd"
									placeholder="비밀번호 확인">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<footer class="section section-primary"></footer>



	
</body>


</html>