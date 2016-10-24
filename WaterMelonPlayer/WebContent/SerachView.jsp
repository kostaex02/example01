<%@page import="watermelon.dto.Artist"%>
<%@page import="java.util.List"%>
<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
</head>
<body>

	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-offset-3 col-md-6">
					<form role="form">
						<div class="form-group">
							<div class="input-group">
								<input type="text" class="form-control"
									placeholder="Enter your email"> <span
									class="input-group-btn"> <a class="btn btn-success"
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
	
				<%	
					
					/*List<Artist> list= request.getParameter("list");
					for(Artist artist:list){
						out.println("<div class='col-md-4'>");
						out.println("<img src='"+artist.getArtistImgUrl()+"' class='img-responsive'>");
						out.println("<h2>"+artist.getSongArtist()+"</h2>");
						out.println("</div>");
					}*/
				%>
					
				</div>
			</div>
		</div>
	</div>
	<footer class="section section-primary">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<p class="text-info text-right">
						<br>
						<br>
					</p>
					<div class="row">
						<div class="col-md-12 hidden-lg hidden-md hidden-sm text-left">
							<a href="#"><i
								class="fa fa-3x fa-fw fa-instagram text-inverse"></i></a> <a
								href="#"><i class="fa fa-3x fa-fw fa-twitter text-inverse"></i></a>
							<a href="#"><i
								class="fa fa-3x fa-fw fa-facebook text-inverse"></i></a> <a href="#"><i
								class="fa fa-3x fa-fw fa-github text-inverse"></i></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>