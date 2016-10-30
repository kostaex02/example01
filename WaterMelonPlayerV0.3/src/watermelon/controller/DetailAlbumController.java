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

import watermelon.dao.GenreDAO;
import watermelon.dao.SongDAO;
import watermelon.dto.Song;

@WebServlet("/DAController")
public class DetailAlbumController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GenreDAO dao = new GenreDAO();
		String albumArtist = request.getParameter("albumArtist");
		String albumName = request.getParameter("albumName");
		String debutDate = request.getParameter("debutDate");
		String albumImgUrl=request.getParameter("albumImgUrl");
		int genreCode = Integer.parseInt(request.getParameter("genreCode"));
		String albumContents = request.getParameter("albumContents");
		String genre = dao.selectGenre(genreCode);
		int albumNo = Integer.parseInt(request.getParameter("albumNo"));
		request.setAttribute("albumImgUrl", albumImgUrl);
		request.setAttribute("albumArtist", albumArtist);
		request.setAttribute("albumName", albumName);
		request.setAttribute("debutDate", debutDate);
		request.setAttribute("genre", genre);
		request.setAttribute("albumContents", albumContents);
		List<Song> SongList = new ArrayList<>();
		SongDAO songDao =new SongDAO();
		try {
			SongList = songDao.selectSongAlbum(albumNo);
			request.setAttribute("SongList", SongList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("detailAlbum.jsp").forward(request, response);
		
	}

}
