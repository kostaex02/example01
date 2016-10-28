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
	<style>
	#btn_play{
		padding:0px 0px;
		border:0px;
	}
	#btn_del{
		padding:0px 0px;
		border:0px;
	}
	label{
		margin-bottom: 0px;
	}
	
	</style>
	<script src="bootstrap/js/jquery-2.2.4.min.js"></script>
	<script>
	$(function() {
		$(document).on("click", "#btn_play", function() {
			location.href="playsong?song_no="+$("#btn_play").attr("name")
		})
	})
	</script>
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
                        
                        
                        <span class="form-group" style="color:#444444; margin-left: 14%">${User.userName}님 환영합니다.</span>
                        	<input type="button" class="btn btn-info btn-sm" value="마이페이지" style="margin-left: 5px">
                            <input type="button" class="btn btn-info btn-sm" value="로그아웃" style="margin-right: 10px">
                    </form>
                </span>
                
                <!-- /.nav-collapse -->
            </div>
        </nav>
        <!-- Main jumbotron for a primary marketing message or call to action -->
        <div class="container-fluid">
			<div class="row">
				<div class="col-sm-3 col-md-2 sidebar">
					<ul class="nav nav-sidebar">
						<li class="active"><a href="#">마이앨범<span class="sr-only">(current)</span></a>
						</li>
						<li><a href="myPagePassword.jsp">비밀번호 변경</a></li>
					</ul>
				</div>
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					<h1 class="page-header">마이앨범</h1>
					<div class="table-responsive">
						<table class="table table-striped">
	       					<tr>
	       						<th></th>
	       						<th>No</th>
	           					<th></th>
	           					<th>곡명</th>
					            <th>아티스트</th>
					        </tr>
					        <tr>
					       		<td class="col-lg-0">
					       			<label data-pg-collapsed><input class="control-label" type="checkbox" value="" align="center"></label>
								</td>
					            <td class="col-lg-0">1</td>
					            <td class="col-lg-1">
					            	<a href="#" class="btn primary" id="btn_play" name="1">
					            		<img src="img/img_play_before.png" class="pull-left" height="25px"/>
					       			</a>
					       			<a href="#" class="btn primary" id="btn_play">
					       				<img src="img/img_add_after.png" class="pull-left" height="25px"/>
					       			</a>
					            </td>
					            <td class="col-lg-3">ipsum</td>
					            <td class="col-lg-8">dolor</td>
					        </tr>
					        <tr>
					        	<td>
					        		<label data-pg-collapsed> 
    								<input class="control-label" type="checkbox" value="">    
									</label>
					        	</td>
					            <td>2</td>
					            <td>
					            	<a href="#" class="btn primary" id="btn_play">
					            		<img src="img/img_play_before.png" class="pull-left" height="25px"/>
					       			</a>
					       			<a href="#" class="btn primary" id="btn_play">
					       				<img src="img/img_add_before.png" class="pull-left" height="25px"/>
					       			</a>
					            </td>
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
					            <td>
					            	<a href="#" class="btn primary" id="btn_play">
					            		<img src="img/img_play_before.png" class="pull-left" height="25px"/>
					       			</a>
					       			<a href="#" class="btn primary" id="btn_play">
					       				<img src="img/img_add_before.png" class="pull-left" height="25px"/>
					       			</a>
					            </td>
					            <td>nec</td>
					            <td>odio</td>
					        </tr>
					        
					    </tbody>
					</table>
					</div>
				
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
