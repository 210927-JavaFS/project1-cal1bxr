package com.revature.services;

import com.revature.models.User;
import com.revature.models.UserDTO;

public class LoginService {

	private UserDAO userDao = new UserDAO();
	
	public boolean login(UserDTO userDto) {
		User user = userDao.getByUsername(userDto.username);
		if (user != null && (userDto.password.equals(user.getPassword()))) {
			return true;
		}

		return false;

	}
}
