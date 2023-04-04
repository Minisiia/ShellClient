package com.example.shellclient.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.beans.Transient;
import java.time.LocalDateTime;

@Data
public class Task {
    private int id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

}
