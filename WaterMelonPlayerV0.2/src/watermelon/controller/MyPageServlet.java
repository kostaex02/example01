package watermelon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import watermelon.Service.UserService;
import watermelon.dto.Album;
import watermelon.dto.User;

@SuppressWarnings("serial")
@WebServlet("/myPage")
public class MyPageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//받아온 유저정보로 유저의 앨범검색
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("User");
		List<Album> albums = UserService.getMyalbum(user.getUserId());
		session.setAttribute("myAlbum", albums);
		request.getRequestDispatcher("myPageAlbum.jsp").forward(request, response);
	}
}
