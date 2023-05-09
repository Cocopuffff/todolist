package org.generation.todolist.controller.dto;

import java.time.LocalDate;

public class TodoDTO {
    private String title;
    private String description;
    private LocalDate targetdate;

    public TodoDTO(String title, String description, LocalDate targetdate) {
        this.title = title;
        this.description = description;
        this.targetdate = targetdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetdate;
    }

    public void setDate(LocalDate targetdate) {
        this.targetdate = targetdate;
    }
}
