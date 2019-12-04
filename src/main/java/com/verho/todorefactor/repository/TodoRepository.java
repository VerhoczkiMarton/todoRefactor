package com.verho.todorefactor.repository;

import com.verho.todorefactor.model.Status;
import com.verho.todorefactor.model.Todo;

import java.util.List;
import java.util.Optional;


public interface TodoRepository {
    Todo save(Todo entity);

    Todo saveAndFlush(Todo entity);

    Optional<Todo> findById(long id);

    void update(Long id, String title);

    List<Todo> findAllByStatus(Status status);

    List<Todo> findAllByStatusString(String status);

    void removeById(Long id);

    void setStatus(Long id, Status status);

    List<Todo> findAll();
}
