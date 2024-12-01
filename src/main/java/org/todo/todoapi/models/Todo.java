package org.todo.todoapi.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Entity
public class Todo {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    @Setter
    @Getter
    @Column(nullable = false)
    private String title;

    @Setter
    @Getter
    @Column(nullable = false)
    private String body;

    @Getter
    @Setter
    @Column(nullable = true)
    private boolean completed = false;

    @Getter
    @Setter
    @JsonFormat
    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate date;

    public Todo(String title, String body, LocalDate date) {
        this.title = title;
        this.body = body;
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.id);
        builder.append("-");
        builder.append(this.title);
        builder.append("-");
        builder.append(this.body);
        return builder.toString();
    }
}
