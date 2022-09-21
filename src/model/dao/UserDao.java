package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.User;
import util.DBUtil;

public class UserDao {
	private UserDao() {}

	private static UserDao instance = new UserDao();

	public static UserDao getInstance() {
		return instance;
	}

	DBUtil dbUtil = DBUtil.getInstance();

	public User login(String id, String password) throws SQLException {
		String sql = "select id, name from user where id = ? and pass = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				User user = new User();
				user.setId(rs.getString(1));
				user.setName(rs.getString(2));
				return user;
			}
			return null;
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
	}
}
