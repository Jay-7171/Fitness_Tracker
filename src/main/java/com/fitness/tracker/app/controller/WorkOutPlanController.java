package com.fitness.tracker.app.controller;

import com.fitness.tracker.app.entity.WorkOutPlan;
import com.fitness.tracker.app.service.WorkOutPlanService;

import jakarta.validation.Valid;

import com.fitness.tracker.app.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/workout-plans")
public class WorkOutPlanController {

    private final WorkOutPlanService workOutPlanService;

    @Autowired
    public WorkOutPlanController(WorkOutPlanService workOutPlanService) {
        this.workOutPlanService = workOutPlanService;
    }

    // Create a new workout plan
    @PostMapping
    public ResponseEntity<WorkOutPlan> createWorkoutPlan(@Valid @RequestBody WorkOutPlan workOutPlan) throws Exception {
        try {
            WorkOutPlan createdPlan = workOutPlanService.createWorkoutPlan(workOutPlan);
            return new ResponseEntity<>(createdPlan, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new Exception("Error creating workout plan: " + e.getMessage());
        }
    }

    // Get a workout plan by ID
    @GetMapping("/{id}")
    public ResponseEntity<WorkOutPlan> getWorkoutPlanById(@PathVariable Long id) {
        Optional<WorkOutPlan> plan = workOutPlanService.getWorkoutPlanById(id);
        return plan.map(ResponseEntity::ok)
                   .orElseThrow(() -> new ResourceNotFoundException("Workout plan with ID not found", id));
    }

    // Get all workout plans for a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<WorkOutPlan>> getWorkoutPlansByUserId(@PathVariable Long userId) throws Exception {
        try {
            List<WorkOutPlan> workoutPlans = workOutPlanService.getWorkoutPlansByUserId(userId);
            return new ResponseEntity<>(workoutPlans, HttpStatus.OK);
        } catch (Exception e) {
            throw new Exception("Error fetching workout plans: " + e.getMessage());
        }
    }

    // Update a workout plan by ID
    @PutMapping("/{id}")
    public ResponseEntity<WorkOutPlan> updateWorkoutPlan(@PathVariable Long id, @Valid @RequestBody WorkOutPlan updatedPlan) throws Exception {
        try {
            WorkOutPlan plan = workOutPlanService.updateWorkoutPlan(id, updatedPlan);
            return new ResponseEntity<>(plan, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            throw e; 
        } catch (Exception e) {
            throw new Exception("Error updating workout plan: " + e.getMessage());
        }
    }

    // Delete a workout plan by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkoutPlan(@PathVariable Long id) throws Exception {
        try {
            boolean isDeleted = workOutPlanService.deleteWorkoutPlan(id);
            return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
        } catch (ResourceNotFoundException e) {
            throw e; 
        } catch (Exception e) {
            throw new Exception("Error deleting workout plan: " + e.getMessage());
        }
    }
}
