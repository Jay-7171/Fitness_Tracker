package com.fitness.tracker.app.controller;

import com.fitness.tracker.app.entity.User;
import com.fitness.tracker.app.service.UserService;

import jakarta.validation.Valid;

import com.fitness.tracker.app.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	// Create a new user
	@PostMapping
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) throws Exception {
		try {
			User createdUser = userService.createUser(user);
			return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new Exception("Error creating user: " + e.getMessage());
		}
	}

	// Get a user by ID
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		Optional<User> user = userService.getUserById(id);
		return user.map(ResponseEntity::ok)
				.orElseThrow(() -> new ResourceNotFoundException("User with ID not found", id));
	}

	// Get all users
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() throws Exception {
		try {
			List<User> users = userService.getAllUsers();
			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			throw new Exception("Error fetching users: " + e.getMessage());
		}
	}

	// Update user by ID
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody User user) throws Exception {
		try {
			User updatedUser = userService.updateUser(id, user);
			return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		} catch (ResourceNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw new Exception("Error updating user: " + e.getMessage());
		}
	}

	// Delete user by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) throws Exception {
		try {
			boolean isDeleted = userService.deleteUser(id);
			return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
		} catch (ResourceNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw new Exception("Error deleting user: " + e.getMessage());
		}
	}
}
