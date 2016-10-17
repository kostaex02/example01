package elec.model.dao;

import java.sql.SQLException;
import java.util.List;

import elec.model.dto.Electronics;

public interface ElectronicsDAO {
	/**
	 * ���ڵ� ��ü �˻�
	 */
	List<Electronics> selectAll() throws SQLException;

	/**
	 * �𵨹�ȣ�� �ش��ϴ� ���ڵ� �˻�
	 * 
	 * @param :	boolean flag - true�̸� ��ȸ�� ����, false�̸� ��ȸ���� ����.
	 */
	Electronics selectByModelNum(String model_num, boolean flag) throws SQLException;

	/**
	 * ���ڵ� ����
	 * 
	 * @return : true-���Լ��� , false - ���Խ���
	 */
	int insert(Electronics electronics) throws SQLException;

	/**
	 * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����
	 * 
	 * @return : true-�������� , false - ��������
	 */
	int delete(String model_num, String password) throws SQLException;

	/**
	 * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����
	 * 
	 * @return : true-�������� , false - ��������
	 */
	int update(Electronics electronics) throws SQLException;
}
