package com.bharath.assignment.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bharath.assignment.DAO.UserDaoInterface;
import com.bharath.assignment.model.UserObject;
/**
 * Service which handles the business logic for User Management application
 * 
 * @author bharath
 *
 */
@Service
public class UserServiceImpl implements UserServiceInterface {

	@Autowired
	private UserDaoInterface userDaoImpl;
	
	//To make rest endpoints working independent of database availability, we have 
	// dummy userDetails Map to store data.

	private Map<String, UserObject> userDetails = new HashMap<String, UserObject>();

	/**
	 * Method to get the user object based on unique emailID
	 * 
	 * @param emailId
	 * @return user Object
	 */
	public UserObject getUser(String emailId) {
		return userDetails.get(emailId);
		//return userDaoImpl.getUser(emailId);
	}

	/**
	 * Method to save the new user
	 * 
	 * @param user data
	 */
	public void createUser(UserObject user) {
		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		user.setLastLogin(timeStamp.toString());
		userDetails.put(user.getEmailId(), user);
		//userDaoImpl.createUser(user);
	}

	/**
	 * Method to update the user details
	 * 
	 * @param emailId
	 * @param userObject
	 */
	public void updateUser(String id, UserObject user) {
		 userDetails.put(id, user);
		//userDaoImpl.updateUser(id, user);
	}

	/**
	 * Method to get all the users
	 * 
	 * @return list of users
	 */
	public List<UserObject> getAllUsers() {
		 return new ArrayList<UserObject>(userDetails.values());
		//return userDaoImpl.getAllUsers();
	}

	/**
	 * Method to delete the user based on email ID
	 * 
	 * @param emailId
	 */
	public void deleteUser(String emailId) {
		 userDetails.remove(emailId);
		//userDaoImpl.deleteUser(emailId);
	}

	/**
	 * Method to update last Login date for the user
	 * 
	 * @param email Id
	 */
	public void updateLastLogin(String emailId) {
		 UserObject userObj = userDetails.get(emailId);
		//UserObject userObj = userDaoImpl.getUser(emailId);
		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		userObj.setLastLogin(timeStamp.toString());
		 userDetails.put(userObj.getEmailId(), userObj);
		//userDaoImpl.updateLastLogin(emailId, timeStamp.toString());
	}

	/**
	 * Method to check if user is valid
	 * 
	 * @param email Id
	 * @param password
	 * 
	 * @return user object
	 */
	public UserObject checkValidUser(String emailId, String password) {
		 UserObject userObj = userDetails.get(emailId);
		//UserObject userObj = userDaoImpl.checkValidUser(emailId, password);
		if (userObj != null && userObj.getPassword().equals(password)) {
			return userObj;
		}
		return null;
	}

}
