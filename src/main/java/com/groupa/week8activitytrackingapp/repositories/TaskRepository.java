package com.groupa.week8activitytrackingapp.repositories;

import com.groupa.week8activitytrackingapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findTaskById(long id);
}
