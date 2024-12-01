package org.todo.todoapi.repositories.todo;

import org.hibernate.query.spi.Limit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.todo.todoapi.models.Todo;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
    public List<Todo> findByTitleContains(String title);
}
