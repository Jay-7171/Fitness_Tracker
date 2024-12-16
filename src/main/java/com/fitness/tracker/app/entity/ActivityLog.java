package com.fitness.tracker.app.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;

@Entity
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "workout_plan_id", nullable = false)
    private WorkOutPlan workoutPlan;

    @NotNull(message = "Exercise name cannot be null")
    @Size(min = 3, max = 100, message = "Exercise name must be between 3 and 100 characters")
    private String exerciseName;

    @Min(value = 1, message = "Duration must be at least 1 minute")
    private Integer duration;  // Duration in minutes

    @NotNull(message = "Intensity cannot be null")
    @Pattern(regexp = "Low|Medium|High", message = "Intensity must be one of: Low, Medium, High")
    private String intensity;  // Low, Medium, High

    @DecimalMin(value = "0.0", message = "Calories burned must be a positive number")
    private Float caloriesBurned;

    @NotNull(message = "Start time cannot be null")
    private LocalDateTime startTime;

    @NotNull(message = "End time cannot be null")
    private LocalDateTime endTime;

    @NotNull(message = "CreatedAt timestamp cannot be null")
    private LocalDateTime createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public WorkOutPlan getWorkoutPlan() {
		return workoutPlan;
	}

	public void setWorkoutPlan(WorkOutPlan workoutPlan) {
		this.workoutPlan = workoutPlan;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getIntensity() {
		return intensity;
	}

	public void setIntensity(String intensity) {
		this.intensity = intensity;
	}

	public Float getCaloriesBurned() {
		return caloriesBurned;
	}

	public void setCaloriesBurned(Float caloriesBurned) {
		this.caloriesBurned = caloriesBurned;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public ActivityLog(Long id, User user, WorkOutPlan workoutPlan,
			@NotNull(message = "Exercise name cannot be null") @Size(min = 3, max = 100, message = "Exercise name must be between 3 and 100 characters") String exerciseName,
			@Min(value = 1, message = "Duration must be at least 1 minute") Integer duration,
			@NotNull(message = "Intensity cannot be null") @Pattern(regexp = "Low|Medium|High", message = "Intensity must be one of: Low, Medium, High") String intensity,
			@DecimalMin(value = "0.0", message = "Calories burned must be a positive number") Float caloriesBurned,
			@NotNull(message = "Start time cannot be null") LocalDateTime startTime,
			@NotNull(message = "End time cannot be null") LocalDateTime endTime,
			@NotNull(message = "CreatedAt timestamp cannot be null") LocalDateTime createdAt) {
		super();
		this.id = id;
		this.user = user;
		this.workoutPlan = workoutPlan;
		this.exerciseName = exerciseName;
		this.duration = duration;
		this.intensity = intensity;
		this.caloriesBurned = caloriesBurned;
		this.startTime = startTime;
		this.endTime = endTime;
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "ActivityLog [id=" + id + ", user=" + user + ", workoutPlan=" + workoutPlan + ", exerciseName="
				+ exerciseName + ", duration=" + duration + ", intensity=" + intensity + ", caloriesBurned="
				+ caloriesBurned + ", startTime=" + startTime + ", endTime=" + endTime + ", createdAt=" + createdAt
				+ "]";
	}

	public ActivityLog() {
	
	}

    
}
