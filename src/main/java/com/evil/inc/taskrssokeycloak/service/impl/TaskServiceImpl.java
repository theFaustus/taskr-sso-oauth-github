package com.evil.inc.taskrssokeycloak.service.impl;

import com.evil.inc.taskrssokeycloak.domain.Task;
import com.evil.inc.taskrssokeycloak.repository.TaskRepository;
import com.evil.inc.taskrssokeycloak.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Transactional
    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Transactional
    @Override
    public List<Task> getTasksByUsername(String username) {
        List<Task> allByUserId = taskRepository.findAllByUserName(username);
        allByUserId.sort(Comparator.comparing(Task::getCreationDateTime).reversed());
        return allByUserId;
    }

    @Override
    public void deleteTaskById(long id) {
        taskRepository.deleteById(id);
    }
}
