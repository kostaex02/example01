package watermelon.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import watermelon.Service.SelectSong;
import watermelon.Service.UserService;
import watermelon.dto.MyAlbum;
import watermelon.dto.Song;
import watermelon.dto.User;

@SuppressWarnings("serial")
@WebServlet("/myPage")
public class MyPageServlet extends HttpServlet {
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SelectSong selectSong = new SelectSong();
		String songNo = request.getParameter("song_no");
		ArrayList<Song> songs = (ArrayList<Song>) selectSong.getPlaylist(songNo);
		HttpSession session = request.getSession();
		if (session.getAttribute("list")!=null) {
			songs = (ArrayList<Song>) session.getAttribute("list");
		} 
		songs = (ArrayList<Song>) selectSong.getPlaylist(songNo);
		session.setAttribute("list", songs);
		PrintWriter out = response.getWriter();
		String str="";
		str = "<script language='javascript'>";
		str += "window.open('view/player.jsp','player', 'width=700, height=500, scrollbars= 0, toolbar=0, menubar=no, resizable=no')";
		str += "</script>";
		out.print(str);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//받아온 유저정보로 유저의 앨범검색
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("User");
		List<MyAlbum> albums = UserService.getMyalbum(user.getUserId());
		session.setAttribute("myAlbum", albums);
		request.getRequestDispatcher("myPageAlbum.jsp").forward(request, response);
	}
}
