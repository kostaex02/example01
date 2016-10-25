<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, minimum-scale=1.0. user-scalable=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>main</title>
        <!-- Bootstrap core CSS -->
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="jumbotron.css" rel="stylesheet">
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    </head>
    <body>
        <nav class="navbar-inverse fixed">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="true" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">WaterMelon</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <form class="navbar-form navbar-right" method="post" action="login">
                        <div class="form-group">
                            <input type="text" placeholder="Email" class="form-control" name="email">
                        </div>
                        <div class="form-group">
                            <input type="password" placeholder="Password" class="form-control" name="pwd">
                        </div>
                        <button type="submit" class="btn btn-success">로그인</button>
                    </form>
                </div>
                <!--/.navbar-collapse -->
            </div>
        </nav>
        <!-- Main jumbotron for a primary marketing message or call to action -->
        <div class="jumbotron">
        <div class="logo-wrapper">
			  <img src="img/wm.png">     
        </div>
            <form class="container text-right" id="contents" action="insert" method="post">
                <p>
    이메일 : <input type="text" placeholder="Email" name="email" >
                <p>
    이름 : <input type="text" placeholder="Name" name="name">
                <p>
    비밀번호 : <input type="password" placeholder="Password" name="pwd">
                <p>
    생일 : <input type="text" placeholder="년월일 6자리 입력" name="birth"><p>
    성별 : 남 <input type="radio" name="gender" value="male" checked>  여 <input type="radio" name="gender" value="female" >
             <p>   
    <button class="btn btn-primary btn-lg" type="submit">가입하기</button></p>
            </form>
        </div>
        <div class="container">
            <!-- Example row of columns -->
            <div class="row">
</div>
            <hr>
            <footer>
                <p>By OneTeams</p>
            </footer>
        </div>         
        <!-- /container -->
        <!-- Bootstrap core JavaScript
    ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="bootstrap/js/jquery-2.2.4.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="bootstrap/js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>
