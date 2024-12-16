package com.fitness.tracker.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.tracker.app.entity.User;
import com.fitness.tracker.app.entity.WorkOutPlan;
import com.fitness.tracker.app.exception.ResourceNotFoundException;
import com.fitness.tracker.app.repository.WorkOutPlanRepo;
import com.fitness.tracker.app.service.WorkOutPlanService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class WorkOutPlanServiceImpl implements WorkOutPlanService {

	@Autowired
	private WorkOutPlanRepo workOutPlanRepository;

	@Override
	public WorkOutPlan createWorkoutPlan(WorkOutPlan workOutPlan) throws Exception {
		try {
			return workOutPlanRepository.save(workOutPlan);
		} catch (Exception e) {
			throw new Exception("Error creating workout plan: " + e.getMessage());
		}
	}

	@Override
	public Optional<WorkOutPlan> getWorkoutPlanById(Long id) {
		return Optional.of(workOutPlanRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Workout plan with ID not found", id)));
	}

	@Override
	public List<WorkOutPlan> getWorkoutPlansByUserId(Long userId) {
		return workOutPlanRepository.findByUserId(userId);
	}

	@Override
	public WorkOutPlan updateWorkoutPlan(Long id, WorkOutPlan updatedWorkOutPlan) throws Exception {
		if (!workOutPlanRepository.existsById(id)) {
			throw new ResourceNotFoundException("Workout plan with ID not found", id);
		}
		updatedWorkOutPlan.setId(id);
		try {
			return workOutPlanRepository.save(updatedWorkOutPlan);
		} catch (Exception e) {
			throw new Exception("Error updating workout plan: " + e.getMessage());
		}
	}

	@Override
	public boolean deleteWorkoutPlan(Long id) throws Exception {
		if (!workOutPlanRepository.existsById(id)) {
			throw new ResourceNotFoundException("Workout plan with ID not found", id);
		}
		try {
			workOutPlanRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			throw new Exception("Error deleting workout plan: " + e.getMessage());
		}
	}
}