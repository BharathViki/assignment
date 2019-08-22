package com.bharath.assignment.Service;

import java.util.List;

import com.bharath.assignment.model.UserObject;

/**
 * Interface which provide the service layer functions
 * 
 * @author bharath
 *
 */
public interface UserServiceInterface {
	
	public UserObject getUser(String emailId);
	
	public void createUser(UserObject user);
	
	public void updateUser(String id, UserObject user);
	
	public List<UserObject> getAllUsers();
	
	public void deleteUser(String emailId);
	
	public void updateLastLogin(String emailId);
	
	public UserObject checkValidUser(String emailId, String password);

}
