package com.amandal97.hibernate;

import java.util.List;

import com.amandal97.hibernate.dao.UserDao;
import com.amandal97.hibernate.model.User;

public class App {

	public static void main(String[] args) {
		
		UserDao userDao = new UserDao();
		
		// Creating a new user object
		User user1 = new User("Zeke", "beast@outlook.com");
		// Save user in table
		userDao.saveUser(user1);
		
		User user2 = new User("Pieck", "cart@gmail.com");
		userDao.saveUser(user2);
		
		// changing the name 
		user2.setName("Pieck Yorishkune");
		// updating the user
		userDao.updateUser(user2);
		
		// get the specific user
		User zeke = userDao.getUserById(user1.getPkUserId());
		
		// Fetch all the users present in the table
		List<User> users = userDao.getAllUsers();
		for (User user : users) {
			System.out.println("Name: " + user.getName());
		}
		
		// Delete the user
		userDao.deleteUser(user1.getPkUserId());

	}

}
