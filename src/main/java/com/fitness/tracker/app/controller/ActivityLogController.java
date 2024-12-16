package com.fitness.tracker.app.controller;

import com.fitness.tracker.app.entity.ActivityLog;
import com.fitness.tracker.app.service.ActivityLogService;

import jakarta.validation.Valid;

import com.fitness.tracker.app.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/activity-logs")
public class ActivityLogController {

	private final ActivityLogService activityLogService;

	@Autowired
	public ActivityLogController(ActivityLogService activityLogService) {
		this.activityLogService = activityLogService;
	}

	// Create a new activity log
	@PostMapping
	public ResponseEntity<ActivityLog> createActivityLog(@Valid @RequestBody ActivityLog activityLog) throws Exception {
		try {
			ActivityLog createdLog = activityLogService.createActivityLog(activityLog);
			return new ResponseEntity<>(createdLog, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new Exception("Error creating activity log: " + e.getMessage());
		}
	}

	// Get an activity log by ID
	@GetMapping("/{id}")
	public ResponseEntity<ActivityLog> getActivityLogById(@PathVariable Long id) {
		Optional<ActivityLog> log = activityLogService.getActivityLogById(id);
		return log.map(ResponseEntity::ok)
				.orElseThrow(() -> new ResourceNotFoundException("Activity log with ID not found", id));
	}

	// Get all activity logs for a user
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<ActivityLog>> getActivityLogsByUserId(@PathVariable Long userId) throws Exception {
		try {
			List<ActivityLog> activityLogs = activityLogService.getActivityLogsByUserId(userId);
			return new ResponseEntity<>(activityLogs, HttpStatus.OK);
		} catch (Exception e) {
			throw new Exception("Error fetching activity logs: " + e.getMessage());
		}
	}

	// Get all activity logs for a workout plan
	@GetMapping("/workout-plan/{workoutPlanId}")
	public ResponseEntity<List<ActivityLog>> getActivityLogsByWorkoutPlanId(@PathVariable Long workoutPlanId) throws Exception {
		try {
			List<ActivityLog> activityLogs = activityLogService.getActivityLogsByWorkoutPlanId(workoutPlanId);
			return new ResponseEntity<>(activityLogs, HttpStatus.OK);
		} catch (Exception e) {
			throw new Exception("Error fetching activity logs: " + e.getMessage());
		}
	}

	// Update an activity log by ID
	@PutMapping("/{id}")
	public ResponseEntity<ActivityLog> updateActivityLog(@PathVariable Long id,
			@Valid @RequestBody ActivityLog updatedLog) throws Exception {
		try {
			ActivityLog updatedActivityLog = activityLogService.updateActivityLog(id, updatedLog);
			return new ResponseEntity<>(updatedActivityLog, HttpStatus.OK);
		} catch (ResourceNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw new Exception("Error updating activity log: " + e.getMessage());
		}
	}

	// Delete an activity log by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteActivityLog(@PathVariable Long id) throws Exception {
		try {
			boolean isDeleted = activityLogService.deleteActivityLog(id);
			return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
		} catch (ResourceNotFoundException e) {
			throw e; 
		} catch (Exception e) {
			throw new Exception("Error deleting activity log: " + e.getMessage());
		}
	}
}
