package org.generation.todolist.repository;

import org.generation.todolist.repository.entity.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
}
