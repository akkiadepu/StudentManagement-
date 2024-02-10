package com.codegnan.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.codegana.beans.User;
import com.codegnan.exception.DatabaseInternalException;
import com.codegnan.helper.ConnectionManager;

public class UserDao extends Dao {

	Logger logger = Logger.getLogger(UserDao.class);

	public UserDao() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

//	find 
	public boolean find(String username, String password) throws ClassNotFoundException, DatabaseInternalException {
		logger.debug("finding the user " + username + "and" + password + "");
		logger.debug("getting local connection");
		try (Connection con = ConnectionManager.getConnection(); Statement stmt = con.createStatement();) {
			con.commit();

			String sql = "select * from customer_2 where username='" + username + "'";
			logger.debug("Executing sql command :" + sql);
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				logger.debug("Found the username :" + username);
				logger.debug("resultSet return true");
				return true;
			} else {
				logger.debug("can not Found the username :" + username);
				logger.debug("resultSet return false");
				return false;
			}

		} catch (SQLException e) {
			logger.debug("SQL exception from UserDao class");
			logger.error(e);
			throw new DatabaseInternalException(e);

		}

	}

	public boolean save(User user) throws DatabaseInternalException {
		logger.debug("save user " + user.getUsername() + " and " + user.getPassword() + "");
		boolean res = false;

		String sql = "insert into customer_2 values(" + user.getUsername() + "," + user.getPassword() + ")";
		logger.debug("Executing sql command :" + sql);
		try {
			Statement stmt = con.createStatement();
			if (stmt.executeUpdate(sql) == 1) {
				logger.debug("saveing the username :" + user.getUsername());
				res = true;
				logger.debug("save() return true");

			}
		} catch (SQLException e) {
			logger.error(e);
			throw new DatabaseInternalException(e);
		}
		logger.debug("Returning true since user inserted successfully");
		return res;

	}

	public boolean edit(String username, String password) throws ClassNotFoundException, DatabaseInternalException {
		logger.debug("edit the user " + username + "and" + password + "");

		boolean res = false;
		try {

			String sql = "update customer_2 set password='" + password + "' where username='" + username + "'";
			logger.debug("Executing sql command :" + sql);
			Statement stmt = con.createStatement();
			logger.debug("UPDATED successfully");
			if (1 == stmt.executeUpdate(sql)) {
				res = true;
			}

		} catch (SQLException e) {

			logger.error(e);
			throw new DatabaseInternalException(e);

		}
		logger.debug("Returning true since user updated successfully");
		return res;

	}

	public boolean delete(String username) throws ClassNotFoundException, DatabaseInternalException {
		logger.debug("Deleting user : " + username);
		boolean res = false;

		try {

			String sql = "delete * customer_2 where username='" + username + "'";
			logger.debug("Executing SQL : " + sql);
			logger.debug("Executing sql command :" + sql);
			Statement stmt = con.createStatement();
			if (1 == stmt.executeUpdate(sql)) {
				logger.debug("DELETED successfully");
				res = true;
			}

		} catch (SQLException e) {

			logger.error(e);
			throw new DatabaseInternalException(e);

		}
		logger.debug("Returning true since user deleted successfully");
		return res;

	}

}
