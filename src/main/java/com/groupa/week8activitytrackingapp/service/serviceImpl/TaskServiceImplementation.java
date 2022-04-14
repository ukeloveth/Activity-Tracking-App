package com.groupa.week8activitytrackingapp.service.serviceImpl;

import com.groupa.week8activitytrackingapp.model.Task;
import com.groupa.week8activitytrackingapp.repository.TaskRepository;
import com.groupa.week8activitytrackingapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskServiceImplementation implements TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImplementation(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }
}
