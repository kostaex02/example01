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
		statement = connection.prepareStatement("SELECT * FROM MY_ALBUM WHERE USER_ID = ?");
		statement.setString(1, id);
		resultSet = statement.executeQuery();
		while (resultSet.next()) {
			MyAlbum album = new MyAlbum(resultSet.getInt(1), resultSet.getString(2),
					resultSet.getString(3), artistDAOdao.selectArtist(resultSet.getInt(4)),
					albumDAO.selectAlbum(resultSet.getInt(5)), resultSet.getString(6), resultSet.getString(7));
			list.add(album);
		}
		return list;
	}

}
