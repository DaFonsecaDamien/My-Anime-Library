package com.example.myanimelibrary.security;

import com.example.myanimelibrary.domain.User;
import com.example.myanimelibrary.domain.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	private final UserService userService;
	private final PasswordEncoder bcryptEncoder;

	public JwtUserDetailsService(UserService userService, PasswordEncoder bcryptEncoder) {
		this.userService = userService;
		this.bcryptEncoder = bcryptEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.getUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	public User save(User user) {
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setPseudo(user.getPseudo());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userService.saveUser(newUser);
	}
}