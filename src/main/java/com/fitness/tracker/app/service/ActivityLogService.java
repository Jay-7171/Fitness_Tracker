package com.fitness.tracker.app.service;

import java.util.List;
import java.util.Optional;

import com.fitness.tracker.app.entity.ActivityLog;

public interface ActivityLogService {
	ActivityLog createActivityLog(ActivityLog activityLog) throws Exception;

	Optional<ActivityLog> getActivityLogById(Long id);

	List<ActivityLog> getActivityLogsByUserId(Long userId);

	List<ActivityLog> getActivityLogsByWorkoutPlanId(Long workoutPlanId);

	ActivityLog updateActivityLog(Long id, ActivityLog updatedActivityLog) throws Exception;

	boolean deleteActivityLog(Long id) throws Exception;
}