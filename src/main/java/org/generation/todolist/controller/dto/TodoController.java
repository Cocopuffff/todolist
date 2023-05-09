package org.generation.todolist.controller.dto;

import jakarta.servlet.http.HttpServletResponse;
import org.generation.todolist.repository.entity.Todo;
import org.generation.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;

@RestController
@RequestMapping("/todolist")
public class TodoController {

    private final TodoService todoService;

    //Dependency injection of TodoService
    public TodoController(@Autowired TodoService todoService) {
        this.todoService = todoService;
    }

    @CrossOrigin
    @GetMapping("/all")
    public Iterable<Todo> getTodos() {
        return todoService.all();
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        todoService.delete(id);
    }

    @CrossOrigin
    @PostMapping("/add")
    public void save (@RequestParam(name="title", required = true) String title,
                      @RequestParam(name="description", required = true) String description,
                      @RequestParam(name="targetdate", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate targetdate,
                      HttpServletResponse response) throws IOException {


        //Validate if target date is before today's date
        LocalDate today = LocalDate.now();
        if (targetdate.isBefore(today)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Target date cannot be before today's date.");
            return;
        }
        TodoDTO todoDTO = new TodoDTO(title, description, targetdate);
        todoService.save(new Todo(todoDTO));
    }

}
