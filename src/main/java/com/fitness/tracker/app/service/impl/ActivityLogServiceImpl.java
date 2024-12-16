package com.fitness.tracker.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.tracker.app.entity.ActivityLog;
import com.fitness.tracker.app.entity.User;
import com.fitness.tracker.app.exception.ResourceNotFoundException;
import com.fitness.tracker.app.repository.ActivityLogRepo;
import com.fitness.tracker.app.service.ActivityLogService;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class ActivityLogServiceImpl implements ActivityLogService {

	@Autowired
	private ActivityLogRepo activityLogRepository;

	@Override
	public ActivityLog createActivityLog(ActivityLog activityLog) throws Exception {
		try {
			return activityLogRepository.save(activityLog);
		} catch (Exception e) {
			throw new Exception("Error creating activity log: " + e.getMessage());
		}
	}

	@Override
	public Optional<ActivityLog> getActivityLogById(Long id) {
		return Optional.of(activityLogRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Activity log with ID not found", id)));
	}

	@Override
	public List<ActivityLog> getActivityLogsByUserId(Long userId) {
		return activityLogRepository.findByUserId(userId);
	}

	@Override
	public List<ActivityLog> getActivityLogsByWorkoutPlanId(Long workoutPlanId) {
		return activityLogRepository.findByWorkoutPlanId(workoutPlanId);
	}

	@Override
	public ActivityLog updateActivityLog(Long id, ActivityLog updatedActivityLog) throws Exception {
		if (!activityLogRepository.existsById(id)) {
			throw new ResourceNotFoundException("Activity log with ID not found", id);
		}
		updatedActivityLog.setId(id);
		try {
			return activityLogRepository.save(updatedActivityLog);
		} catch (Exception e) {
			throw new Exception("Error updating activity log: " + e.getMessage());
		}
	}

	@Override
	public boolean deleteActivityLog(Long id) throws Exception {
		if (!activityLogRepository.existsById(id)) {
			throw new ResourceNotFoundException("Activity log with ID not found", id);
		}
		try {
			activityLogRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			throw new Exception("Error deleting activity log: " + e.getMessage());
		}
	}
}
