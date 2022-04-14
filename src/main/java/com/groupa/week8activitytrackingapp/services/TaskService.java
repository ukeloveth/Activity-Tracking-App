package com.groupa.week8activitytrackingapp.services;

import com.groupa.week8activitytrackingapp.model.Task;

import java.util.List;

public interface TaskService {
    Task createTask(String title, String description);
    List<Task> getAllTasks();
    Task findTaskByTitle(String title);
    Task getTaskById(long id);

    Task editTask(Long id, String title, String description, String status);
}
