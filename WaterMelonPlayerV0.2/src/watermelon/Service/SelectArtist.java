package watermelon.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import watermelon.dao.ArtistDAO;
import watermelon.dto.Artist;

public class SelectArtist {
	ArtistDAO dao =new ArtistDAO();
	List<Artist> list = new ArrayList<>();
	
	public List<Artist> artistSelect(String content){
		try {
			list = dao.selectArtist(content);
		} catch (SQLException e) {
			e.getStackTrace();
		}
		
		return list;
	}
}
