package com.fitness.tracker.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.tracker.app.entity.User;
import com.fitness.tracker.app.exception.ResourceNotFoundException;
import com.fitness.tracker.app.repository.UserRepo;
import com.fitness.tracker.app.service.UserService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Override
	public User createUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public Optional<User> getUserById(long id) {

		return Optional.ofNullable(
				userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with ID ", id)));
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User updateUser(Long id, User updatedUser) throws Exception {
		if (!userRepo.existsById(id)) {
			throw new ResourceNotFoundException("User with ID not found", id);
		}
		updatedUser.setId(id);
		try {
			return userRepo.save(updatedUser);
		} catch (Exception e) {
			throw new Exception("Error updating user: " + e.getMessage());
		}
	}

	@Override
	public boolean deleteUser(long id) throws Exception {
		if (!userRepo.existsById(id)) {
			throw new ResourceNotFoundException("User with ID not found", id);
		}
		try {
			userRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			throw new Exception("Error deleting user: " + e.getMessage());
		}
	}
}
