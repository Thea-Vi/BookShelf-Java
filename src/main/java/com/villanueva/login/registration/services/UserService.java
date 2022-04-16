package com.villanueva.login.registration.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.villanueva.login.registration.models.LoginUser;
import com.villanueva.login.registration.models.User;
import com.villanueva.login.registration.respositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User register(User newUser, BindingResult result) {
		if (userRepository.findByEmail(newUser.getEmail()).isPresent()) {
			result.rejectValue("email", "Unique", "This Email is already in use!");
		}
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
		}
		if (result.hasErrors()) {
			return null;

		} else {
			String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashed);
			return userRepository.save(newUser);

		}

	}

	public User login(LoginUser newLogin, BindingResult result) {
		if (result.hasErrors()) {
			return null;
		}
		Optional<User> potentialUser = userRepository.findByEmail(newLogin.getEmail());
		if (!potentialUser.isPresent()) {
			result.rejectValue("email", "Unique", "Unknown email!");
			return null;

		}
		User user = potentialUser.get();
		if (!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Password");
		}
		if (result.hasErrors()) {
			return null;
		} else {
			return user;
		}
	}

	public User findUser(Long id) {
		return this.userRepository.findById(id).orElse(null);
	}

}
