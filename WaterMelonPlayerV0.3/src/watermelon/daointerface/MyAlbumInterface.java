package watermelon.daointerface;

import java.sql.SQLException;
import java.util.List;

import watermelon.dto.MyAlbum;

public interface MyAlbumInterface {
	/**
	 * ���̵� �ش��ϴ� ���̾ٹ��� ã�Ƽ� ����Ʈ�� ��� ����
	 * @return ���̾ٹ��� ���� ������ ��� MyAlbum��ü
	 * @throws SQLException
	 */
	List<MyAlbum> getMyAlbum(String id) throws SQLException;
}
