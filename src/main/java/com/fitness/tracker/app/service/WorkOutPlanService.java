package com.fitness.tracker.app.service;

import java.util.List;
import java.util.Optional;

import com.fitness.tracker.app.entity.User;
import com.fitness.tracker.app.entity.WorkOutPlan;



public interface WorkOutPlanService {
	  	WorkOutPlan createWorkoutPlan(WorkOutPlan workOutPlan) throws Exception;

	    Optional<WorkOutPlan> getWorkoutPlanById(Long id);

	   
	    List<WorkOutPlan> getWorkoutPlansByUserId(Long userId);

	 
	    WorkOutPlan updateWorkoutPlan(Long id, WorkOutPlan updatedWorkOutPlan) throws Exception;

	    boolean deleteWorkoutPlan(Long id) throws Exception;
}
