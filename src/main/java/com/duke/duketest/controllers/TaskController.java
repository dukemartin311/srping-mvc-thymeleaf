package com.duke.duketest.controllers;

import com.duke.duketest.models.Task;
import com.duke.duketest.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping("/tasks")
    public String getTasks(Model model){
        model.addAttribute("tasks", taskService.getAllTasks());
        return "tasks";
    }

    @RequestMapping("/taskform")
    public String getTaskForm(Model model){
        model.addAttribute("task", new Task());
        return "taskform";
    }

    @PostMapping("/addtask")
    public String addTask(@ModelAttribute Task task, Model model) {
        this.taskService.addTask(task);
        model.addAttribute("tasks", taskService.getAllTasks());
        return "tasks";
    }

    @RequestMapping("/removeTask")
    public String removeTask(@RequestParam String id, Model model){
        this.taskService.removeTask(new Long(id));
        model.addAttribute("tasks", taskService.getAllTasks());
        return "tasks";
    }
}
