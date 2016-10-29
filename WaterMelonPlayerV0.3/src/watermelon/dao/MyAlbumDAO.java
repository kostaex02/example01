package watermelon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import watermelon.daointerface.MyAlbumInterface;
import watermelon.dto.MyAlbum;
import watermelon.util.DBUtil;

public class MyAlbumDAO implements MyAlbumInterface {
	ArtistDAO artistDAOdao = new ArtistDAO();
	AlbumDAO albumDAO =  new AlbumDAO();
	
	@Override
	public List<MyAlbum> getMyAlbum(String id) throws SQLException {
		
		List<MyAlbum> list = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		connection = DBUtil.getConnection();
		statement = connection.prepareStatement("SELECT D.my_album_no, D.user_id, "
				+ "D.song_name, E.song_name, D.artist_name, D.album_name, D.song_url, "
				+ "D.imgurl FROM my_album D join song E ON D.song_name=E.SONG_NO WHERE "
				+ "D.USER_ID = ?");
		statement.setString(1, id);
		resultSet = statement.executeQuery();
		
		while (resultSet.next()) {
			MyAlbum album = new MyAlbum(resultSet.getInt(1), resultSet.getString(2),
					resultSet.getInt(3), resultSet.getString(4), artistDAOdao.selectArtistName(resultSet.getInt(5)),
					albumDAO.selectAlbumName(resultSet.getInt(6)), resultSet.getString(7), resultSet.getString(8));
			list.add(album);
		}
		return list;
	}

}
