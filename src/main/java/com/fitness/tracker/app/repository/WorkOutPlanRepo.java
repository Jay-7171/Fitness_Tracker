package com.fitness.tracker.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fitness.tracker.app.entity.User;
import com.fitness.tracker.app.entity.WorkOutPlan;


@Repository
public interface WorkOutPlanRepo extends JpaRepository<WorkOutPlan, Long>{
	 List<WorkOutPlan> findByUserId(Long id);
}
