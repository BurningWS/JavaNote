import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestScroll {

	public static void main(String[] args) {
		try {
			new oracle.jdbc.driver.OracleDriver();
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ws","ws");
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			//resultSetType - 缁撴灉板嗙被鍨嬶紝瀹冩槸 ResultSet.TYPE_FORWARD_ONLY銆丷esultSet.TYPE_SCROLL_INSENSITIVE 鎴?ResultSet.TYPE_SCROLL_SENSITIVE 涔嬩竴
			//resultSetConcurrency - 骞跺彂绫诲瀷锛涘畠鏄?ResultSet.CONCUR_READ_ONLY 鎴?ResultSet.CONCUR_UPDATABLE 涔嬩竴	


			ResultSet rs = stmt
					.executeQuery("select * from emp order by sal");
			rs.next(); //绗竴鏉¤褰?
			System.out.println(rs.getInt(1));
			rs.last(); //链€鍚庝竴鏉?
			System.out.println(rs.getString(1));
			System.out.println(rs.isLast());
			System.out.println(rs.isAfterLast());
			System.out.println(rs.getRow());
			rs.previous(); //链掓暟绗簩鏉?
			System.out.println(rs.getString(1));
			rs.absolute(6); //鐩存帴瀹氢綅绗叚鏉★紝缁濆瀹氢綅
			System.out.println(rs.getString(1));
			
			rs.close();
			stmt.close();
			conn.close();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
