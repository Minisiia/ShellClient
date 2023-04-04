package com.example.shellclient.service;

import com.example.shellclient.model.Task;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@ShellComponent
public class UserShellService {
    WebClient webClient;

    @Autowired
    public UserShellService(WebClient webClient) {
        this.webClient = webClient;
    }

    @ShellMethod("Get task by ID")
    public Task getTaskById(@ShellOption(help = "ID of the task")int id) {
        return webClient.get()
                .uri("http://localhost:8099/tasks/" + id)
                .retrieve()
                .bodyToMono(Task.class)
                .map(task -> {task.setId(id);
                return task;})
                .block();
    }

    @ShellMethod("Get list of tasks")
    public List<Task> getAllTasks() {
        return webClient.get()
                .uri("http://localhost:8099/tasks")
                .retrieve()
                .bodyToFlux(Task.class)
                .collectList()
                .block();
    }

    @ShellMethod("Add new task")
    public String addTask(@ShellOption(help = "Title of the task (max 100 characters)", defaultValue = "Untitled") String title,
                          @ShellOption(help = "Description of the task", defaultValue = " ") String description) throws JsonProcessingException {
        String taskJson = taskToJson(title, description);
        return webClient.post()
                .uri("http://localhost:8099/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(taskJson)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    @ShellMethod("Update task by ID")
    public String updateTask(@ShellOption(help = "ID of the task to update") int id,
                             @ShellOption(help = "Title of the task (max 100 characters)", defaultValue = "Untitled") String title,
                             @ShellOption(help = "Description of the task", defaultValue = " ") String description) throws JsonProcessingException {
        String taskJson = taskToJson(title, description);
        return webClient.put()
                .uri("http://localhost:8099/tasks/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(taskJson)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    @ShellMethod("Delete task by ID")
    public void deleteTask(@ShellOption(help = "ID of the task to update") int id) {
        webClient.delete()
                .uri("http://localhost:8099/tasks/" + id)
                .retrieve()
                .bodyToMono(Task.class)
                .block();
    }

    private String taskToJson(String title, String description) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Task task = new Task(title, description);
        return objectMapper.writeValueAsString(task);
    }
}
