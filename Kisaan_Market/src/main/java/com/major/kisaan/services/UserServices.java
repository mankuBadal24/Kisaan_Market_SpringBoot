package com.major.kisaan.services;

import org.springframework.stereotype.Service;

import com.major.kisaan.dao.UserDao;
import com.major.kisaan.user.User;

@Service
public class UserServices {

	 private final UserDao userRepository;

	    public UserServices(UserDao userRepository) {
	        this.userRepository = userRepository;
	    }

	    public void registerUser(User user) {
	        userRepository.save(user);
	    }

	    public User login(String phoneNumber, String password) {
	        User user = userRepository.findByPhoneNumber(phoneNumber);
	        if (user != null && user.getPassword().equals(password)) {
	            return user; 
	        }
	        return null; 
	    }
}
