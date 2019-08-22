package com.bharath.assignment.DAO;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.bharath.assignment.model.UserObject;

/**
 * DAO class which handles the persistence operation for User Management application
 * 
 * @author bharath
 *
 */
@Repository
public class UserDaoImpl implements UserDaoInterface {
	//Named Paraemeter jdbc template object to run the query
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public UserObject getUser(String emailId) {
		String sql = "SELECT email_Id, name, password, lastLogin_Date FROM User WHERE email_Id = :emailId";
		SqlParameterSource parameterSource = new MapSqlParameterSource("emailId", emailId);
		return (UserObject) namedParameterJdbcTemplate.queryForObject(sql, parameterSource, new UserMapper());
	}

	public void createUser(UserObject user) {
		String SQL = "INSERT INTO User (email_Id, name, password, lastLogin_Date) VALUES (:emailId, :name, :password, :lastLogin_Date)";
		Map<String, String> namedParameters = new HashMap<String, String>();
		namedParameters.put("name", user.getName());
		namedParameters.put("email_Id", user.getEmailId());
		namedParameters.put("password", user.getPassword());
		namedParameters.put("lastLogin_Date", user.getLastLogin());
		namedParameterJdbcTemplate.update(SQL, namedParameters);
	}

	public void updateUser(String id, UserObject user) {
		String SQL = "UPDATE USER SET name= :name, password=:password, lastLogin_Date=:lastLoginDate WHERE email_Id = :emailId";
		Map<String, String> namedParameters = new HashMap<String, String>();
		namedParameters.put("name", user.getName());
		namedParameters.put("emailId", user.getEmailId());
		namedParameters.put("password", user.getPassword());
		namedParameters.put("lastLoginDate", user.getLastLogin());
		namedParameterJdbcTemplate.update(SQL, namedParameters);
	}

	public List<UserObject> getAllUsers() {
		System.out.println("Datasoruce value = "+namedParameterJdbcTemplate.getJdbcTemplate().getDataSource());
		String SQL = "SELECT email_Id, name, password, lastLogin_Date FROM User";
		List<UserObject> users = (List<UserObject>) namedParameterJdbcTemplate.query(SQL, new UserMapper());
		return users;
	}

	public void deleteUser(String emailId) {
		String SQL = "DELETE FROM User WHERE email_Id = :emailId";
		Map<String, String> namedParameters = new HashMap<String, String>();;
		namedParameters.put("emailId", emailId);

		namedParameterJdbcTemplate.update(SQL, namedParameters);
	}

	public void updateLastLogin(String emailId, String lastLoginDate) {
		String SQL = "UPDATE USER SET  lastLogin_Date=:lastLoginDate WHERE email_Id = :emailId";
		Map<String, String> namedParameters = new HashMap<String, String>();
		namedParameters.put("lastLoginDate", lastLoginDate);
		namedParameters.put("emailId", emailId);
		namedParameterJdbcTemplate.update(SQL, namedParameters);

	}

	public UserObject checkValidUser(String emailId, String password) {
		String sql = "SELECT email_Id, name, password, lastLogin_Date FROM User WHERE email_Id = :emailId AND password = :password";
		Map<String, String> namedParameters = new HashMap<String, String>();
		namedParameters.put("password", password);
		namedParameters.put("emailId", emailId);
		return (UserObject) namedParameterJdbcTemplate.queryForObject(sql, namedParameters, new UserMapper());
	}

}
