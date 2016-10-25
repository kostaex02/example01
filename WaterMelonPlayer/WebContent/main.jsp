<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Bootstrap core CSS -->
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="offcanvas.css" rel="stylesheet">
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<title>Insert title here</title>
</head>
<body>
 <nav class="navbar-inverse">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">WaterMelon</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse" >
                    <form class="navbar-form">
                        <div class="form-group">
                        	<select name="select" action="select" style="height:30px;">
                        		<option value="song">곡이름</option>
                        		<option value="album">앨범</option>
                        		<option value="artist">아티스트</option>
                       	 	</select>
                            <input type="text" size="30" class="form-control" id="content">
                        </div>
                        <button type="submit" class="btn btn-success">검색</button>
                        <div class="form-group" style="color:red; margin-left:100px">
                        	&nbsp; &nbsp; <%=request.getParameter("id") %>>님 환영합니다. &nbsp; &nbsp;
                        </div>
                        	<input type="button" class="btn btn-info" value="로그아웃">
                            <input type="button" class="btn btn-info" value="회원정보변경">
                    </form>
                </div>
                
                <!-- /.nav-collapse -->
            </div>
            <!-- /.container -->
        </nav>
        <!-- /.navbar -->
        <div class="container">
            <div class="row row-offcanvas row-offcanvas-right">
                <div class="col-xs-12 col-sm-9">
                    <p class="pull-right visible-xs"><button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button></p>
                    <div class="row">
                        <div class="col-xs-6 col-lg-4">
                            <a href="#" class="thumbnail"> 
                                <img src="img/1989.png" alt=""> 
                            </a>
                            <h3 class="text-center">가수</h3>
                            <p class="text-center">앨범이름1</p>
                        </div>
                        <!--/.col-xs-6.col-lg-4-->
                        <div class="col-xs-6 col-lg-4">
                            <a href="#" class="thumbnail"> 
                                <img src="img/1989.png" alt=""> 
                            </a>
                            <h3 class="text-center">가수</h3>
                            <p class="text-center">앨범이름1</p>
                        </div>
                        <!--/.col-xs-6.col-lg-4-->
                        <div class="col-xs-6 col-lg-4">
                            <a href="#" class="thumbnail"> 
                                <img src="img/1989.png" alt=""> 
                            </a>
                            <h3 class="text-center">가수</h3>
                            <p class="text-center">앨범이름1</p>
                        </div>
                        <!--/.col-xs-6.col-lg-4-->
                        <div class="col-xs-6 col-lg-4">
                            <a href="#" class="thumbnail"> 
                                <img src="img/1989.png" alt=""> 
                            </a>
                            <h3 class="text-center">가수</h3>
                            <p class="text-center">앨범이름1</p>
                        </div>
                        <!--/.col-xs-6.col-lg-4-->
                        <div class="col-xs-6 col-lg-4">
                            <a href="#" class="thumbnail"> 
                                <img src="img/1989.png" alt=""> 
                            </a>
                            <h3 class="text-center">가수</h3>
                            <p class="text-center">앨범이름1</p>
                        </div>
                        <!--/.col-xs-6.col-lg-4-->
                        <div class="col-xs-6 col-lg-4">
                            <a href="#" class="thumbnail"> 
                                <img src="img/1989.png" alt=""> 
                            </a>
                            <h3 class="text-center">가수</h3>
                            <p class="text-center">앨범이름1</p>
                        </div>
                        <!--/.col-xs-6.col-lg-4-->
                    </div>
                    <!--/row-->
                </div>
                <!--/.col-xs-12.col-sm-9-->
                <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
                    <div class="list-group">
                        <a href="#" class="list-group-item active">Link</a>
                        <a href="#" class="list-group-item">Link</a>
                        <a href="#" class="list-group-item">Link</a>
                        <a href="#" class="list-group-item">Link</a>
                        <a href="#" class="list-group-item">Link</a>
                        <a href="#" class="list-group-item">Link</a>
                        <a href="#" class="list-group-item">Link</a>
                        <a href="#" class="list-group-item">Link</a>
                        <a href="#" class="list-group-item">Link</a>
                        <a href="#" class="list-group-item">Link</a>
                    </div>
                </div>
                <!--/.sidebar-offcanvas-->
            </div>
            <!--/row-->
            <hr>
            <footer>
                <p>&copy; OneTeam</p>
            </footer>
        </div>
        <!--/.container-->
        <!-- Bootstrap core JavaScript
    ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="assets/js/jquery.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="assets/js/ie10-viewport-bug-workaround.js"></script>
        <script>
        $(document).ready(function () {
            $('[data-toggle="offcanvas"]').click(function () {
                $('.row-offcanvas').toggleClass('active')
            });
        });
    </script>
</body>
</html>