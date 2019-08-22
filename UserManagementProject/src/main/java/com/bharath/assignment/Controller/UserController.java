package com.bharath.assignment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bharath.assignment.Service.UserServiceInterface;
import com.bharath.assignment.model.UserObject;
/**
 * Controller to provide rest endpoints for User management application
 * 
 * @author bharath
 *
 */
@RestController
@RequestMapping("/UserManagement")
public class UserController {
	
	@Autowired
	private UserServiceInterface userService;
	
		
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	public UserObject getUser(@PathVariable("id") String id){
		return userService.getUser(id);
	}
	
	@RequestMapping(value="/showUsers", method=RequestMethod.GET)
	public List<UserObject> showUsers(){
		return userService.getAllUsers();
	}
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public void addUser(@RequestBody UserObject userObject){
		userService.createUser(userObject);
	}
	
	@RequestMapping(value="/modifyUser/{id}", method=RequestMethod.PUT)
	public void modifyUser(@RequestBody UserObject userObject, @PathVariable("id") String id){
		userService.updateUser(id, userObject);
	}
	
	@RequestMapping(value="/removeUser/{id}", method=RequestMethod.DELETE)
	public void removeUser(@PathVariable("id") String id){
		userService.deleteUser(id);
	}
	
	@RequestMapping(value="/loginUser/{id}/password/{pass}", method=RequestMethod.GET)
	public UserObject loginUser(@PathVariable("id") String id, @PathVariable("pass") String pass){
		return userService.checkValidUser(id, pass);
	}
	
	@RequestMapping(value="/logoutUser/{id}", method=RequestMethod.PUT)
	public void updateLastLogin(@PathVariable("id") String id){
		userService.updateLastLogin(id);
	}

}
