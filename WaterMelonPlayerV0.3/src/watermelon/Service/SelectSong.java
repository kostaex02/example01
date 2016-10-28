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
	/**
	 * ���ȣ�� �ش� ���� ���̸�, ��Ƽ��Ʈ, ��URL, �ٹ�URL�� �����´�.
	 * @param songNo(���ȣ)
	 * @return ã�ƿ� Song��ü���� ArrayList
	 */
	public List<Song> getPlaylist(String songNo) {
		List<Song> list = new ArrayList<>();
				list.add(dao.getPlaylist(songNo));
		return list;
	}
	
}

