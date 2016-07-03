import java.sql.*;

public class TestJDBC {
	public static void main(String[] args) {
		// new oracle.jdbc.driver.OracleDriver();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 瀹炰緥鍖栨椂镊姩鍚慏riverManager娉ㄥ唽

			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			// 阒胯タ鍚с€傜粓浜庤瘯鎴愬姛浜?55鎴栬€呮槸127.0.0.1
		
			stmt = conn.createStatement();
			//榛樿鎯呭喌涓嬬被鍨嬩负 TYPE_FORWARD_ONLY锛屽苟甯︽湁 CONCUR_READ_ONLY 骞跺彂绾у埆銆?

			rs = stmt.executeQuery("select * from dept");  //绫讳技浜巆ursor
			while (rs.next()) {
				System.out.println(rs.getString("deptno"));
				System.out.println(rs.getInt("deptno"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close(); // 鍚庢墦寮€鍏埚叧
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}