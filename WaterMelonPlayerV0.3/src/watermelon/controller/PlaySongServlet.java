package watermelon.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import watermelon.Service.SelectSong;
import watermelon.dto.Song;

@SuppressWarnings("serial")
@WebServlet("/playsong")
public class PlaySongServlet extends HttpServlet {
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SelectSong selectSong = new SelectSong();
		String songNo = request.getParameter("song_no");
		System.out.println("플레이송 서블렛 - songNo :"+songNo);
		ArrayList<Song> songs = (ArrayList<Song>) selectSong.getPlaylist(songNo);
		HttpSession session = request.getSession();
		if (session.getAttribute("list")!=null) {
			songs = (ArrayList<Song>) session.getAttribute("list");
		}
		songs = (ArrayList<Song>) selectSong.getPlaylist(songNo);
		session.setAttribute("list", songs);
		PrintWriter out = response.getWriter();
		out.println("go!");
	}
}
