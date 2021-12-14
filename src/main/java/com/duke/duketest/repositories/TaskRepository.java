package com.duke.duketest.repositories;


import com.duke.duketest.models.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
