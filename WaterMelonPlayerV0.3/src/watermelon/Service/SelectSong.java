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
	/**
	 * 곡번호로 해당 곡의 곡이름, 아티스트, 곡URL, 앨범URL을 가져온다.
	 * @param songNo(곡번호)
	 * @return 찾아온 Song객체들의 ArrayList
	 */
	public List<Song> getPlaylist(String songNo) {
		List<Song> list = new ArrayList<>();
				list.add(dao.getPlaylist(songNo));
		return list;
	}
	
}

