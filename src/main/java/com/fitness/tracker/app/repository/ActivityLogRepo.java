package com.fitness.tracker.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitness.tracker.app.entity.ActivityLog;
import com.fitness.tracker.app.entity.User;
import com.fitness.tracker.app.entity.WorkOutPlan;


public interface ActivityLogRepo extends JpaRepository<ActivityLog, Long> {
	List<ActivityLog> findByUserId(long id);
	    List<ActivityLog> findByWorkoutPlanId(long Id);
}
