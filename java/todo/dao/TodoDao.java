package todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import todo.dto.*;

public class TodoDao {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb1";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "connect123!@#";
	
	public int addTodo(TodoDto dto) {
		String query = "insert into todo(title, name, sequence) values(?,?,?)";

		try (Connection conn = DriverManager.getConnection(dburl,dbUser,dbpasswd);
				PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getSequence());
			return pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public List<TodoDto> getTodos() {
		List<TodoDto> list = new ArrayList();
		String query = "select  id, title, name, sequence, type, date_format(regdate, '%Y.%m.%d') as date from todo order by regdate";

		try (Connection conn = DriverManager.getConnection(dburl,dbUser,dbpasswd);
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				TodoDto dto = new TodoDto();
				dto.setId(rs.getLong("id"));
				dto.setName(rs.getString("name"));
				dto.setRegDate(rs.getString("date"));
				dto.setSequence(rs.getInt("sequence"));
				dto.setTitle(rs.getString("title"));
				dto.setType(rs.getString("type"));
				list.add(dto);
			}
			return list;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public int updateTodo(int id, String type) {
		String query = "update todo set type = ? where id = ?";

		try (Connection conn = DriverManager.getConnection(dburl,dbUser,dbpasswd);
				PreparedStatement pstmt = conn.prepareStatement(query)) {
				pstmt.setString(1, type);
				pstmt.setLong(2, id);
		
			return pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			return 0;
		}
	}

}