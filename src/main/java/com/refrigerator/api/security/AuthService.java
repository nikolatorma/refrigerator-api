package com.refrigerator.api.security;

import com.refrigerator.api.dto.*;
import com.refrigerator.api.exception.InvalidUsernameOrPasswordException;
import com.refrigerator.api.exception.UserAlreadyExistsException;
import com.refrigerator.api.repository.UserRepository;

import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
	}

    public void register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.username())) {
        	throw new UserAlreadyExistsException("User with username " + request.username() + " already exists.");
        }
        com.refrigerator.api.model.User user = (com.refrigerator.api.model.User) User.builder()
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .build();
        userRepository.save(user);
    }

    public String authenticate(AuthRequest request) {
        com.refrigerator.api.model.User user = userRepository.findByUsername(request.username())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new InvalidUsernameOrPasswordException("Invalid username or password");
        }

        return jwtService.generateToken(user.getUsername());
    }
}


