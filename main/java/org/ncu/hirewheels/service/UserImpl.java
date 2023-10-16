package org.ncu.hirewheels.service;

import java.util.List;

import org.ncu.hirewheels.entity.User;
import org.ncu.hirewheels.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserService {
	
	private UserRepository userRepository;
	
	public UserImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).orElse(null);		
	}

	@Override
	public User updateUser(User User, long id) {
		// TODO Auto-generated method stub
		User existingUser = userRepository.findById(id).orElse(null);
		
		existingUser.setFirstName(User.getFirstName());
		existingUser.setLastName(User.getLastName());
		existingUser.setEmail(User.getEmail());
		// save existing User to DB
		userRepository.save(existingUser);
		return existingUser;
	}

	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		userRepository.findById(id).orElse(null);
		userRepository.deleteById(id);
	}

}
