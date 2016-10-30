package watermelon.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import watermelon.dao.SongDAO;
import watermelon.dto.Song;

@WebServlet("/DAController")
public class DetailAlbumController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String albumArtist = request.getParameter("albumArtist");
		String albumName = request.getParameter("albumName");
		String debutDate = request.getParameter("debutDate");
		String genreCode = request.getParameter("genreCode");
		int albumNo = Integer.parseInt(request.getParameter("albumNo"));
		request.setAttribute("albumArtist", albumArtist);
		request.setAttribute("albumName", albumName);
		request.setAttribute("debutDate", debutDate);
		request.setAttribute("genreCode", genreCode);
		List<Song> SongList = new ArrayList<>();
		SongDAO songDao =new SongDAO();
		try {
			SongList = songDao.selectSongAlbum(albumNo);
			request.setAttribute("SongList", SongList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
