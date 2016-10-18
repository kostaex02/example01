package elec.model;

import java.sql.SQLException;
import java.util.List;

import elec.model.dao.ElectronicsDAOImpl;
import elec.model.dto.Electronics;

public class ElectronicsService {
	private static ElectronicsDAOImpl electronicsDao = new ElectronicsDAOImpl();

	public ElectronicsService(){
		
	}
	/**
	 * ElectronicsDAOImpl�� ��緹�ڵ� �˻��ϴ� �޼ҵ� ȣ��
	 */
	public static List<Electronics> selectAll() throws SQLException{
		List<Electronics> list = null;
		list = electronicsDao.selectAll();
	
		return list;
	}
	
	/**
	 * ElectronicsDAOImpl�� ���ڵ� �����ϴ� �޼ҵ� ȣ��
	 */
	public static int insert(Electronics electronics) throws SQLException{
		return electronicsDao.insert(electronics);
	}

	/**
	 * ElectronicsDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� �˻��ϴ� �޼ҵ� ȣ��
	 * 
	 * @param :
	 *            boolean flag - ��ȸ�� ���� ���θ� �Ǻ��ϴ� �Ű�������(true�̸� ��ȸ������ / false�̸�
	 *            ��ȸ�� ���� ����)
	 */
	public static Electronics selectByModelNum(String modelNum, boolean flag) throws SQLException{
		Electronics elec = electronicsDao.selectByModelNum(modelNum, flag);
		return elec;
	}
	/**
	 * ElectronicsDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� ���� �޼ҵ� ȣ��
	 */
	public static int delete(String modelNum, String password){
		return 1;
	}

	/**
	 * ElectronicsDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� ���� �޼ҵ� ȣ��
	 */
	public static int update(String modelNum, String password){
		return 1;
	}
}
