package org.todo.todoapi.services.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.todo.todoapi.dto.TodoBodyRequest;
import org.todo.todoapi.models.Todo;
import org.todo.todoapi.repositories.todo.TodoRepository;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{

    private TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Iterable<Todo> getAllTodo() {
        return this.todoRepository.findAll();
    }

    @Override
    public Todo createNewTodo(TodoBodyRequest todo) {
        var newTodo = todo.mapToTodo();
        return this.todoRepository.save(newTodo);
    }

    @Override
    public Iterable<Todo> searchTodoByTitle(String title) {
        var data = this.todoRepository.findByTitleContains(title);
        return data;
    }
}
