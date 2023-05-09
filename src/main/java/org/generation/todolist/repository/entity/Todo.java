package org.generation.todolist.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.generation.todolist.controller.dto.TodoDTO;

import java.time.LocalDate;

@Entity
public class Todo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private LocalDate targetdate;

    public Todo() {}

    public Todo(TodoDTO todoDTO) {
        this.title = todoDTO.getTitle();
        this.description = todoDTO.getDescription();
        this.targetdate = todoDTO.getTargetDate();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setTargetDate(LocalDate targetdate) {
        this.targetdate = targetdate;
    }

    @Override
    public String toString() {
        return "Todo{id=" + id + ", title=" + title + ", description=" + description + ", target date=" + targetdate + '}';
    }
}
