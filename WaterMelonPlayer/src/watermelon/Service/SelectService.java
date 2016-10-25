package watermelon.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import watermelon.dao.SongDAO;
import watermelon.dto.Song;

public class SelectService {
	SongDAO dao = new SongDAO();
	List<Song> list = new ArrayList<>();
	
	public List<Song> songSelect(String content) {
		try {
			list = dao.selectSongName(content);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
