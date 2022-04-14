package com.groupa.week8activitytrackingapp.repository;

import com.groupa.week8activitytrackingapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
