package org.todo.todoapi.controllers;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.todo.todoapi.dto.TodoBodyRequest;
import org.todo.todoapi.helpers.ResponseHandler;
import org.todo.todoapi.services.todo.TodoService;

@RestController
@RequestMapping("api/v1/todo")
public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllTodoData(){
        var data = this.todoService.getAllTodo();
        return ResponseHandler.JSONResponse(HttpStatus.OK, "Success Get All Data", data);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createNewTodo(@Valid @RequestBody TodoBodyRequest todoBodyRequest){
        var data = this.todoService.createNewTodo(todoBodyRequest);
        return ResponseHandler.JSONResponse(HttpStatus.CREATED, "Success Created", data);
    }

    @GetMapping
    public ResponseEntity<Object> searchByTitle(@RequestParam String title){
        if (title == null || title.isEmpty()) {
            return ResponseHandler.JSONResponse(HttpStatus.BAD_REQUEST, "Bad Request", null);
        }
        var data = this.todoService.searchTodoByTitle(title);
        return ResponseHandler.JSONResponse(HttpStatus.OK, "Success Search By Title", data);
    }
}
