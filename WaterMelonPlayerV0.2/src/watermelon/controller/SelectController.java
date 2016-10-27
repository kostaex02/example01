package watermelon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import watermelon.Service.SelectSong;
import watermelon.dto.Song;

@WebServlet("/select")
public class SelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String select = request.getParameter("select");
		String content = request.getParameter("content");
		SelectSong service = new SelectSong();
		//select값에 따라 service의 메소드를 다르게 호출
		if(select.equals("song")){
			List<Song> list =service.songSelect(select);
			request.setAttribute("list", list);
			request.getRequestDispatcher("seachSong.jsp").forward(request, response);
		}else if(select.equals("artist")){
			
		}else if(select.equals("album")){
			
		}
			
	}

}
