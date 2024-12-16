package com.fitness.tracker.app.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.*;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Username cannot be null")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String username;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Password cannot be null")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @NotNull(message = "First name cannot be null")
    @Size(min = 1, max = 50, message = "First name must be between 1 and 50 characters")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @Size(min = 1, max = 50, message = "Last name must be between 1 and 50 characters")
    private String lastName;

    @Past(message = "Date of birth must be in the past")
    private LocalDate dob;

    @DecimalMin(value = "0.0", message = "Height must be a positive number")
    private Float height;

    @DecimalMin(value = "0.0", message = "Weight must be a positive number")
    private Float weight;

    @NotNull(message = "CreatedAt timestamp cannot be null")
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "user")
    private List<WorkOutPlan> workoutPlans;

    @OneToMany(mappedBy = "user")
    private List<ActivityLog> activityLogs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
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

	public List<WorkOutPlan> getWorkoutPlans() {
		return workoutPlans;
	}

	public void setWorkoutPlans(List<WorkOutPlan> workoutPlans) {
		this.workoutPlans = workoutPlans;
	}

	public List<ActivityLog> getActivityLogs() {
		return activityLogs;
	}

	public void setActivityLogs(List<ActivityLog> activityLogs) {
		this.activityLogs = activityLogs;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", height=" + height + ", weight=" + weight
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", workoutPlans=" + workoutPlans
				+ ", activityLogs=" + activityLogs + "]";
	}

	public User(Long id,
			@NotNull(message = "Username cannot be null") @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters") String username,
			@NotNull(message = "Email cannot be null") @Email(message = "Email should be valid") String email,
			@NotNull(message = "Password cannot be null") @Size(min = 6, message = "Password must be at least 6 characters long") String password,
			@NotNull(message = "First name cannot be null") @Size(min = 1, max = 50, message = "First name must be between 1 and 50 characters") String firstName,
			@NotNull(message = "Last name cannot be null") @Size(min = 1, max = 50, message = "Last name must be between 1 and 50 characters") String lastName,
			LocalDate dob, @DecimalMin(value = "0.0", message = "Height must be a positive number") Float height,
			@DecimalMin(value = "0.0", message = "Weight must be a positive number") Float weight,
			@NotNull(message = "CreatedAt timestamp cannot be null") LocalDateTime createdAt, LocalDateTime updatedAt,
			List<WorkOutPlan> workoutPlans, List<ActivityLog> activityLogs) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.height = height;
		this.weight = weight;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.workoutPlans = workoutPlans;
		this.activityLogs = activityLogs;
	}

	public User() {
		
	}
    
    
}

