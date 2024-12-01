package org.todo.todoapi.services.todo;

import org.todo.todoapi.dto.TodoBodyRequest;
import org.todo.todoapi.models.Todo;


public interface TodoService {
    Iterable<Todo> getAllTodo();
    Todo createNewTodo(TodoBodyRequest todo);
    Iterable<Todo> searchTodoByTitle(String title);
}
