import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conn.ConnectionProvider;

public class TestConn {
	public static void main(String[] args) {
		try (Connection conn = ConnectionProvider.makeConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT 1")) {
			if (rs.next()) {
				System.out.println(rs.getInt(1) == 1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
