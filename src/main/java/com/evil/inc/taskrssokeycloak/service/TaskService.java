package com.evil.inc.taskrssokeycloak.service;

import com.evil.inc.taskrssokeycloak.domain.Task;

import java.util.List;

public interface TaskService {
    Task addTask(Task task);
    List<Task> getTasksByUsername(String username);
    void deleteTaskById(long id);
}
