package elec.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBUtil {

	static DataSource ds;

	static {
		try {
			Context initContext = new InitialContext();
			ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/myoracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ¿¬°á
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	// ´Ý±â
	public static void dbClose(Connection con, Statement st, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (st != null) {
				st.close();
				st = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
