package org.ncu.hirewheels.service;

import java.util.List;

import org.ncu.hirewheels.entity.User;

public interface UserService {
	User saveUser(User User);
	List<User> getAllUsers();
	User getUserById(long id);
	User updateUser(User User, long id);
	void deleteUser(long id);

}
