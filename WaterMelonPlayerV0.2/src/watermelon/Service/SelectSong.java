package watermelon.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import watermelon.dao.SongDAO;
import watermelon.dto.Song;

public class SelectSong {
	SongDAO dao = new SongDAO();
	List<Song> list = new ArrayList<>();
	
	public List<Song> songSelect(String content) {
		try {
			System.out.println(content+" : Service SelectSong까지옴" );
			//dao 에서 얻어온 list값 list에 담기
			list = dao.selectSongName(content);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//담은 값 리턴
		return list;
	}
	
	
}

