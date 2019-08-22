package com.bharath.assignment.DAO;

import java.util.List;

import com.bharath.assignment.model.UserObject;
/**
 * Interface which provide the dao functions
 * 
 * @author bharath
 *
 */

public interface UserDaoInterface {
	
	public UserObject getUser(String emailId);
	
	public void createUser(UserObject user);
	
	public void updateUser(String id, UserObject user);
	
	public List<UserObject> getAllUsers();
	
	public void deleteUser(String emailId);
	
	public void updateLastLogin(String emailId, String lastLoginDate);
	
	public UserObject checkValidUser(String emailId, String password);
}
