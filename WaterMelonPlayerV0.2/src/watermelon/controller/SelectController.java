package watermelon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import watermelon.Service.SelectAlbum;
import watermelon.Service.SelectArtist;
import watermelon.Service.SelectSong;
import watermelon.dto.Artist;
import watermelon.dto.Song;

@WebServlet("/select")
public class SelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String select = request.getParameter("select");
		String content = request.getParameter("content");
		
		//select값에 따라 service의 메소드를 다르게 호출
		if(select.equals("song")){
			SelectSong service = new SelectSong();
			List<Song> list =service.songSelect(content);
			request.setAttribute("list", list);
			request.getRequestDispatcher("searchSong.jsp").forward(request, response);
		}else if(select.equals("artist")){
			SelectArtist service = new SelectArtist();
			List<Artist> list =service.artistSelect(content);
			request.setAttribute("list", list);
			request.getRequestDispatcher("searchArtist.jsp").forward(request, response);
		}else if(select.equals("album")){
			/*SelectAlbum service = new SelectAlbum();
			List<Song> list =service.albumSelect(content);
			request.setAttribute("list", list);
			request.getRequestDispatcher("searchAlbum.jsp").forward(request, response);*/
		}
			
	}

}
