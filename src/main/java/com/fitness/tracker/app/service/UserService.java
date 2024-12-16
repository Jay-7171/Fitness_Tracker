package com.fitness.tracker.app.service;

import java.util.List;
import java.util.Optional;

import com.fitness.tracker.app.entity.User;

public interface UserService {
	public User createUser(User user) throws Exception;
    public Optional<User> getUserById(long id);
    public List<User> getAllUsers();
    public User updateUser(Long id, User updatedUser) throws Exception;
    public boolean deleteUser(long id) throws Exception;
}
