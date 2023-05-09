package org.generation.todolist.service;

import org.generation.todolist.repository.TodoRepository;
import org.generation.todolist.repository.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TodoServiceImplementor implements TodoService {

    private final TodoRepository todoRepository;

    //Dependency injection of TodoRepository
    public TodoServiceImplementor(@Autowired TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    //Create new or update To do object
    @Override
    public Todo save(Todo todo) {
        return this.todoRepository.save(todo);
    }

    //Returns all To do objects in an ArrayList
    @Override
    public ArrayList<Todo> all() {
        ArrayList<Todo> result = new ArrayList<>();
        todoRepository.findAll().forEach(result::add);
        return result;
    }

    //Returns To do object by To do ID
    @Override
    public Todo findById(int todoId) {
        Optional<Todo> todoOptional = todoRepository.findById(todoId);
        Todo todo = todoOptional.get();
        return todo;
    }

    //Deletes To do object by To do ID
    @Override
    public void delete(int todoId) {
        this.todoRepository.deleteById(todoId);
    }


}
