<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Jumbotron Template for Bootstrap</title>
        <!-- Bootstrap core CSS -->
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="test.css" rel="stylesheet">
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    </head>
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
                <span id="navbar" class="navbar-collapse collapse" style="padding-left: 24%">
                    <form class="navbar-form">
                    <div class="col">
                       <div class="col-lg-4">
  						  <div class="input-group">
    						<div class="input-group-btn">
     							<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">곡명<span class="caret"></span></button>
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
                        
                        
                        <span class="form-group" style="color:red; margin-left: 14%">김김김님 환영합니다.</span>
                        	<input type="button" class="btn btn-info btn-sm" value="회원정보변경" style="margin-left: 5px">
                            <input type="button" class="btn btn-info btn-sm" value="로그아웃" style="margin-right: 10px">
                    </form>
                </span>
                
                <!-- /.nav-collapse -->
            </div>
        </nav>
        <!-- Main jumbotron for a primary marketing message or call to action -->
        <div class="container">
            <div class="row row-offcanvas ">
                <div class="col-xs-12 col-sm-9">
                    <p class="pull-right visible-xs"><button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button></p>
                    <div class="row"> <!-- 행 -->
                    	<div class="col-xs-6 col-lg-4" style="margin-top: 50px; outline-style: none;"> <!-- 열 -->
                            <img src="img/1989.png" style="margin: 0px">
                        </div>
                    	<div class="col-xs-6 col-lg-8" style="margin-top : 50px; outline-style: none; ">
                    		<h2 class="text-left">ALBUM</h2>
                        	<h3 class="text-left">아티스트 : 신화</h3>
                            <h3 class="text-left">발매일&nbsp; &nbsp; : 2016-10-22</h3>
                            <h3 class="text-left">장르&nbsp; &nbsp; &nbsp; &nbsp; : 발라드</h3>
                        </div>
                        <!--/.col-xs-6.col-lg-4-->
                    </div>
                    <br>
                    수록곡
                    <span class="badge" style="background-color:green">3</span>
                    <hr style="border-color:green">
                    <!--/row-->
                    <div class="row">
                    	<table class="table table-striped">
    					<thead>
        					<tr>
        						<th></th>
        						<th>No</th>
            					<th>button</th>
            					<th>곡명</th>
					            <th>아티스트</th>
					        </tr>
					    </thead>
					    <tbody>
					        <tr>
					       		<td>
					       			<label data-pg-collapsed> 
    								<input class="control-label" type="checkbox" value="">    
									</label>
								</td>
					            <td>1</td>
					            <td>Lorem</td>
					            <td>ipsum&nbsp;<span class="label label-danger">TITLE</span></td>
					            <td>dolor</td>
					        </tr>
					        <tr>
					        	<td>
					        		<label data-pg-collapsed> 
    								<input class="control-label" type="checkbox" value="">    
									</label>
					        	</td>
					            <td>2</td>
					            <td>amet</td>
					            <td>consectetur</td>
					            <td>adipiscing</td>
					        </tr>
					        <tr>
					        	<td>
					        		<label data-pg-collapsed> 
    								<input class="control-label" type="checkbox" value="">    
									</label>
					        	</td>
					            <td>3</td>
					            <td>Integer</td>
					            <td>nec</td>
					            <td>odio</td>
					        </tr>
					        
					    </tbody>
					</table>
                    </div>
                     <hr style="border-color:green">
                     <h3>앨범소개</h3>
                     <hr>
                     <h6>Taylor Swift <br><br><br>노래를 잘함</h6>
                     <hr style="border-color:green">
                     <h3>리뷰</h3>
                     <div class="col-xs-6 col-lg-10" style="outline-style: none; ">
                        	<textarea class="form-control" rows="2"></textarea>
                     </div>
                     <div class="col-xs-6 col-lg-2" style="outline-style: none; ">
                        	<button type="button" class="btn btn-default btn-lg" >등록</button>
                     </div>
                     .
                     </div>
                     <div class="row">
                     
                     <table class="table table-striped">
    					<tbody>
					        <tr>
					       		<td class="col-lg-1">ID</td>
					            <td class="col-lg-11">Contents</td>
					        </tr>
					        <tr>
					            <td>ID</td>
					            <td>Contents</td>
					        </tr>
					        <tr>
					        	<td>ID</td>
					            <td>Contents</td>
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
        <script src="bootstrap/js/jquery-2.2.4.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="bootstrap/js/ie10-viewport-bug-workaround.js"></script>
        <script>
        $(document).ready(function () {
            $('[data-toggle="test"]').click(function () {
                $('.row-test').toggleClass('active')
            });
        });
    </script>
    </body>
</html>
