package elec.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import elec.model.dto.Electronics;
import elec.util.DBUtil;

public class ElectronicsDAOImpl implements ElectronicsDAO {

	@Override
	public List<Electronics> selectAll() throws SQLException {
		List<Electronics> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		
		try{
			con = DBUtil.getConnection();
			pr = con.prepareStatement("select * from Electronics");
			rs = pr.executeQuery();
			
			while(rs.next()){
				Electronics elec = new Electronics(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), 
						rs.getString(5), rs.getDate(6).toString(), rs.getInt(7), rs.getString(8), rs.getInt(9));
				list.add(elec);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.dbClose(con, pr, rs);
		}
		
		return list;
	}
	
	@Override
	public Electronics selectByModelNum(String model_num, boolean flag) throws SQLException {
		Electronics elec = null;
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		try{
			con = DBUtil.getConnection();
			pr = con.prepareStatement("select * from Electronics where model_num=?");
			pr.setString(1, model_num);
			
			rs = pr.executeQuery();
			if(rs.next()){
				elec = new Electronics(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), 
						rs.getString(5), rs.getDate(6).toString(), rs.getInt(7), rs.getString(8), rs.getInt(9));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.dbClose(con, pr, null);
		}
		
		return elec;
	}

	@Override
	public int insert(Electronics electronics) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement pr = null;

		try{
			con = DBUtil.getConnection();
			pr = con.prepareStatement("insert into Electronics values(?,?,?,?,?,sysdate,0,?,?)");
			pr.setString(1, electronics.getModelNum());
			pr.setString(2, electronics.getModelName());
			pr.setInt(3, electronics.getPrice());
			pr.setString(4, electronics.getDescription());
			pr.setString(5, electronics.getPassword());
			pr.setString(6, electronics.getfName());
			pr.setInt(7, electronics.getfSize());
			
			pr.executeUpdate();
			result = 1;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.dbClose(con, pr, null);
		}
		
		return result;
	}
	
	@Override
	public int delete(String model_num, String password) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement pr = null;
		try{
			con = DBUtil.getConnection();
			pr = con.prepareStatement("delete from Electronics where model_num = ? and password = ?");
			pr.setString(1, model_num);
			pr.setString(2, password);
			pr.executeQuery();
			result = 1;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.dbClose(con, pr, null);
		}
		
		return result;
	}

	@Override
	public int update(Electronics electronics) throws SQLException {
		Connection con = null;
		PreparedStatement pr = null;
		int result = 0;
		try{
			con = DBUtil.getConnection();
			pr = con.prepareStatement("update Electronics set model_name = ? , price = ? , description = ? where model_num = ?");
			pr.setString(1, electronics.getModelName());
			pr.setInt(2, electronics.getPrice());
			pr.setString(3, electronics.getDescription());
			pr.setString(4, electronics.getModelNum());
			
			pr.executeUpdate();
			result = 1;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.dbClose(con, pr, null);;
		}
		
		return result;
	}


}
