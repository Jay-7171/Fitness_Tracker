package com.fitness.tracker.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class WorkOutPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@NotNull(message = "Name cannot be null")
	@Size(min = 3, max = 100, message = "Workout plan name must be between 3 and 100 characters")
	private String name;

	@NotNull(message = "Description cannot be null")
	@Size(min = 10, max = 255, message = "Description must be between 10 and 255 characters")
	private String description;

	@NotNull(message = "Start date cannot be null")
	@PastOrPresent(message = "Start date must be in the past or present")
	private LocalDate startDate;

	@NotNull(message = "End date cannot be null")
	@Future(message = "End date must be in the future")
	private LocalDate endDate;

	@Min(value = 1, message = "Frequency per week must be at least 1")
	@Max(value = 7, message = "Frequency per week must be at most 7")
	private Integer frequencyPerWeek;

	@NotNull(message = "Goal cannot be null")
	@Size(min = 3, max = 50, message = "Goal must be between 3 and 50 characters")
	private String goal;

	@NotNull(message = "CreatedAt timestamp cannot be null")
	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	@OneToMany(mappedBy = "workoutPlan")
	private List<ActivityLog> activityLogs;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Integer getFrequencyPerWeek() {
		return frequencyPerWeek;
	}

	public void setFrequencyPerWeek(Integer frequencyPerWeek) {
		this.frequencyPerWeek = frequencyPerWeek;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<ActivityLog> getActivityLogs() {
		return activityLogs;
	}

	public void setActivityLogs(List<ActivityLog> activityLogs) {
		this.activityLogs = activityLogs;
	}

	

	public WorkOutPlan(Long id, User user,
			@NotNull(message = "Name cannot be null") @Size(min = 3, max = 100, message = "Workout plan name must be between 3 and 100 characters") String name,
			@NotNull(message = "Description cannot be null") @Size(min = 10, max = 255, message = "Description must be between 10 and 255 characters") String description,
			@NotNull(message = "Start date cannot be null") @PastOrPresent(message = "Start date must be in the past or present") LocalDate startDate,
			@NotNull(message = "End date cannot be null") @Future(message = "End date must be in the future") LocalDate endDate,
			@Min(value = 1, message = "Frequency per week must be at least 1") @Max(value = 7, message = "Frequency per week must be at most 7") Integer frequencyPerWeek,
			@NotNull(message = "Goal cannot be null") @Size(min = 3, max = 50, message = "Goal must be between 3 and 50 characters") String goal,
			@NotNull(message = "CreatedAt timestamp cannot be null") LocalDateTime createdAt, LocalDateTime updatedAt,
			List<ActivityLog> activityLogs) {
		super();
		this.id = id;
		this.user = user;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.frequencyPerWeek = frequencyPerWeek;
		this.goal = goal;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.activityLogs = activityLogs;
	}

	@Override
	public String toString() {
		return "WorkoutPlan [id=" + id + ", user=" + user + ", name=" + name + ", description=" + description
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", frequencyPerWeek=" + frequencyPerWeek
				+ ", goal=" + goal + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", activityLogs="
				+ activityLogs + "]";
	}

	public WorkOutPlan() {
	
	}

	
}
