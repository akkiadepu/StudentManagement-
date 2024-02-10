package com.codegnan.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.codegnan.exception.DatabaseInternalException;
import com.codegnan.helper.ConnectionManager;

public class UserDao extends Dao{

	Logger log = Logger.getLogger(UserDao.class);
	public UserDao() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}
//	find 
	public boolean find(String username,String password) throws ClassNotFoundException, DatabaseInternalException {
		log.debug("finding the user "+username+"and"+password+"");
		log.debug("getting local connection");
		try(Connection con =ConnectionManager.getConnection();
			Statement stmt =con.createStatement();){
			con.commit();
			
			String sql="select * from customer_2 where username='"+username+"' and password='"+password+"'";
			log.debug("Executing sql command :"+sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				log.debug("Found the username :"+username);
				log.debug("resultSet return true");
				return true;
			}
			else {
				log.debug("can not Found the username :"+username);
				log.debug("resultSet return false");
				return false;
			}

		}
		catch (SQLException e) {
			log.debug("SQL exception from UserDao class");
			throw new DatabaseInternalException(e);
			
		}
	
		
	}
	
	public boolean edit(String username,String password) throws ClassNotFoundException, DatabaseInternalException {
		log.debug("finding the user "+username+"and"+password+"");
		log.debug("getting local connection");
		boolean res=false;
		try {
			
			String sql="update customer_2 set username='"+username+"' and password='"+password+"'";
			log.debug("Executing sql command :"+sql);
			Statement stmt =con.createStatement();
			if(1==stmt.executeUpdate(sql)) {
				res=true;
			}

		}
		catch (SQLException e) {
			log.debug("SQL exception from UserDao class");
			log.error(e);
			throw new DatabaseInternalException(e);
			
		}
		return res;
	
		
	}
	
	public boolean delete(String username) throws ClassNotFoundException, DatabaseInternalException {
		log.debug("finding the user "+username+"");
		log.debug("getting local connection");
		boolean res=false;
		try {
			
			String sql="delete * customer_2 where username='"+username+"'";
			log.debug("Executing sql command :"+sql);
			Statement stmt =con.createStatement();
			if(1==stmt.executeUpdate(sql)) {
				res=true;
			}

		}
		catch (SQLException e) {
			log.debug("SQL exception from UserDao class");
			log.error(e);
			throw new DatabaseInternalException(e);
			
		}
		return res;
	
		
	}
	
	
	
	
	
	

}
