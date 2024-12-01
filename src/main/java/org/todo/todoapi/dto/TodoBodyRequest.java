package org.todo.todoapi.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.todo.todoapi.models.Todo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TodoBodyRequest {

    @Getter
    @Setter
    @NotBlank(message = "{Todo 'title' is required}")
    public String title;

    @Getter
    @Setter
    @NotBlank(message = "{Todo 'body' is required}")
    public String body;

    @Getter
    @Setter
    @NotBlank(message = "{Todo 'date' is required}")
    public String date;

    public Todo mapToTodo(){
        var date = LocalDate.parse(this.date);
        return new Todo(this.title, this.body, date);
    }
}
