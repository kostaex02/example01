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
			System.out.println(content+" : Service SelectSong������" );
			//dao ���� ���� list�� list�� ���
			list = dao.selectSongName(content);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//���� �� ����
		return list;
	}
	
	
}

