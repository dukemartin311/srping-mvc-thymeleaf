package com.duke.duketest.services;

import com.duke.duketest.models.Task;
import com.duke.duketest.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return StreamSupport
                .stream(taskRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void addTask(Task task) {
        taskRepository.save(task);
    }

    public void removeTask(Long id) {
        taskRepository.deleteById(id);
    }

}
