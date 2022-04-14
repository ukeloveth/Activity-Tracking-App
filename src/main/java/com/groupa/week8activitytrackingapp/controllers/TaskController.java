package com.groupa.week8activitytrackingapp.controllers;

import com.groupa.week8activitytrackingapp.dto.TaskDto;
import com.groupa.week8activitytrackingapp.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class TaskController {
    private final TaskServiceImpl taskService;


    @Autowired
    public TaskController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public String home(Model model) {
        TaskDto task = new TaskDto();
        SearchDto searchDto = new SearchDto();
        var taskList = taskService.getAllTasks();
        model.addAttribute("list",taskList);
        model.addAttribute("taskObject", task);
        model.addAttribute("searchDto", searchDto);
        return "tasks";
    }


    @GetMapping("/error")
    public String error() {
        return "error";
    }



    @PostMapping("/tasks")
    public String createTask(@ModelAttribute("taskObject") TaskDto task) {
        try {
            Task createdTask = taskService.createTask(task.getTitle(), task.getDescription());
        } catch (Exception ex) {
            return "task_creation_error";
        }
        return "task_creation_success";
    }

    @GetMapping("/tasks/{title}")
    public String taskByTitle(@ModelAttribute("searchDto") SearchDto searchDto, Model model) {
        TaskDto task = new TaskDto();
        Task searchTask = taskService.findTaskByTitle(searchDto.getTitle());
        model.addAttribute("searchFor",searchTask);
        model.addAttribute("taskObject", task);
        return "search_task";

    }
    @GetMapping("/tasks/{id}")
    public String editTask(@PathVariable Long id, Model model) {
        model.addAttribute("task", taskService.getTaskById(id));
        return "tasks";
    }


}

