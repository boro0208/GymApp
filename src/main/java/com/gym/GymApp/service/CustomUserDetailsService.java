package com.gym.GymApp.service;

import com.gym.GymApp.auth.CustomUserDetails;
import com.gym.GymApp.model.User;
import com.gym.GymApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository repository;

	@Autowired
	public CustomUserDetailsService(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = repository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("User not found!");
		}
		return new CustomUserDetails(user);
	}
}
