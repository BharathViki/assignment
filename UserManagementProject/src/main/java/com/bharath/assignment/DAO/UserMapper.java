package com.bharath.assignment.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bharath.assignment.model.UserObject;

public class UserMapper implements RowMapper<UserObject>{

	public UserObject mapRow(ResultSet rs, int arg1) throws SQLException {
		UserObject userObj = new UserObject();
		userObj.setEmailId(rs.getString("email_Id"));
		userObj.setName(rs.getString("name"));
		userObj.setPassword(rs.getString("password"));
		userObj.setLastLogin(rs.getString("lastLogin_Date"));
		return userObj;
	}

}
