package com.groupa.week8activitytrackingapp.services.servicesImpl;

import com.groupa.week8activitytrackingapp.model.Task;
import com.groupa.week8activitytrackingapp.model.TaskStatus;
import com.groupa.week8activitytrackingapp.repositories.TaskRepository;
import com.groupa.week8activitytrackingapp.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    List<Task> taskList = new ArrayList<>();

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(String title, String description) {
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setStatus(TaskStatus.CREATED);
        return  taskRepository.save(task);
    }
    @Override
    public List<Task> getAllTasks() {
        taskList = taskRepository.findAll();
        return taskList;
    }

    @Override
    public Task findTaskByTitle(String title) {
        Optional<Task> ans =  taskList.stream().filter(x -> x.getTitle().equals(title)).findFirst();
        return ans.orElse(null);

    }

    @Override
    public Task getTaskById(long id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public Task editTask(Long id, String title, String description, String status) {
        Task task = taskRepository.findTaskById(id);

        if ( status!=null && !status.isEmpty() ){
            status = status.toUpperCase();
            TaskStatus taskStatus = TaskStatus.valueOf(status);
            task.setStatus(taskStatus);
        }

        if ( title!=null && !title.isEmpty() ){
            task.setTitle(title);
        }

        if ( description!=null && !description.isEmpty() ){
            task.setDescription(description);
        }

        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }



}
