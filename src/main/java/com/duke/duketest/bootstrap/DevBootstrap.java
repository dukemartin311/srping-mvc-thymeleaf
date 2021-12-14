package com.duke.duketest.bootstrap;

import com.duke.duketest.models.Task;
import com.duke.duketest.repositories.TaskRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

  private TaskRepository taskRepository;

  public DevBootstrap(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
      initData();
  }

  private void initData() {
    Task taskOne = new Task("Task one","Description task one");
    taskRepository.save(taskOne);

    Task taskTwo = new Task("Task two","Description task two");
    taskRepository.save(taskTwo);
  }
}
