package com.groupa.week8activitytrackingapp.controller;

import com.groupa.week8activitytrackingapp.dto.TaskDto;
import com.groupa.week8activitytrackingapp.model.Task;
import com.groupa.week8activitytrackingapp.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping("/all")
    public String getAllTask(Model model){
       List<Task> tasklist = taskService.getAllTask();
        System.out.println(tasklist);
        model.addAttribute("TaskList",tasklist);
        return "/";
    }
}
