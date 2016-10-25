package watermelon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import watermelon.Service.SelectService;
import watermelon.dto.Song;

@WebServlet("/select")
public class SelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String select = request.getParameter("select");
		SelectService service = new SelectService();
		if(select.equals("song")){
			List<Song> list =service.songSelect(select);
			request.setAttribute("list", list);
			request.getRequestDispatcher("SerachView.jsp").forward(request, response);
		}else if(select.equals("artist")){
			
		}else if(select.equals("album")){
			
		}
			
	}

}
