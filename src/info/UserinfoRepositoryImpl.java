package info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conn.ConnectionProvider;
import exceptions.DataIOException;

public class UserinfoRepositoryImpl implements UserinfoRepository {

	@Override
	public int countByID(String inputId) throws DataIOException{
		String sql = "SELECT count(*) FROM project_game.user where id = ?";
		try (Connection conn = ConnectionProvider.makeConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, inputId);
			
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return rs.getInt(1);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DataIOException(e);
		}
		return 0;
	}

	@Override
	public int countByNickName(String inputNickname) {
		String sql = "SELECT count(*) FROM project_game.user where nickname = ?";
		try (Connection conn = ConnectionProvider.makeConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, inputNickname);
			
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DataIOException(e);
		}
		return 0;
	}

	@Override
	public int insert(String inputId, String inputPassword, String inputNickname) {
		String sql = "INSERT INTO project_game.user (id, password, nickname) values (?, ?, ?)";
		try (Connection conn = ConnectionProvider.makeConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, inputId);
			stmt.setString(2, inputPassword);
			stmt.setString(3, inputNickname);
			
			return stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DataIOException(e);
		}
	}

}
