package model.service;

import java.sql.SQLException;

import dto.User;
import model.dao.UserDao;

public class UserService {
	private UserService() {}
	private static UserService instance = new UserService();
	public static UserService getInstance() {
		return instance;
	}
	
	UserDao userDao = UserDao.getInstance();
	
	public User login(String id, String password) throws SQLException {
		return userDao.login(id, password);
	}
}
