package com.evil.inc.taskrssokeycloak.web;

import com.evil.inc.taskrssokeycloak.domain.Priority;
import com.evil.inc.taskrssokeycloak.domain.Task;
import com.evil.inc.taskrssokeycloak.service.TaskService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public ModelAndView tasks(@AuthenticationPrincipal OAuth2User principal){
        ModelAndView modelAndView = new ModelAndView("tasks");
        final String username = principal.getAttribute("login");
        final String avatarUrl = principal.getAttribute("avatar_url");
        modelAndView.addObject("userName", username);
        modelAndView.addObject("avatarUrl", avatarUrl);
        modelAndView.addObject("userTasks", taskService.getTasksByUsername(username));
        modelAndView.addObject("priorities", Priority.values());
        modelAndView.addObject("task", new Task());
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addTask(@ModelAttribute Task task, @AuthenticationPrincipal OAuth2User principal){
        final String username = principal.getAttribute("login");
        task.setUserName(username);
        taskService.addTask(task);
        return new ModelAndView("redirect:/tasks");
    }

    @PostMapping("/delete/{taskId}")
    public ModelAndView deleteTask(@PathVariable long taskId){
        taskService.deleteTaskById(taskId);
        return new ModelAndView("redirect:/tasks");
    }


}
