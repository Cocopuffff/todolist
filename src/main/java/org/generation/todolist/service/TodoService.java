package org.generation.todolist.service;

import org.generation.todolist.repository.entity.Todo;
import java.util.ArrayList;

public interface TodoService {

    //Create new or update To do object into database
    public Todo save(Todo todo);


    //Returns all To do objects in an ArrayList from database
    public ArrayList<Todo> all();


    //Returns To do object by To do ID from database
    public Todo findById(int todoId);


    //Deletes To do object by To do ID from database
    public void delete(int todoId);

}
