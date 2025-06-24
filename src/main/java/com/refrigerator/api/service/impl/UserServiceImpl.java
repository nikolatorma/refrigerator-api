package com.refrigerator.api.service.impl;

import org.springframework.stereotype.Service;

import com.refrigerator.api.model.User;
import com.refrigerator.api.repository.UserRepository;
import com.refrigerator.api.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
	}
}
