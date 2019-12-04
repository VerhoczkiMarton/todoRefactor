package com.verho.todorefactor.repository;

import com.verho.todorefactor.model.Status;
import com.verho.todorefactor.model.Todo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Qualifier("mem")
public class TodoMemRepository implements TodoRepository {

    private final List<Todo> DATA = new ArrayList<>();

    public Todo save(Todo todo) {
        DATA.add(todo);
        return todo;
    }

    @Override
    public Todo saveAndFlush(Todo entity) {
        save(entity);
        return entity;
    }

    public Optional<Todo> findById(long id) {
        return Optional.ofNullable(DATA.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null));
    }

    public void update(Long id, String title) {
        findById(id).get().setTitle(title);
    }

    public List<Todo> findAllByStatusString(String statusString) {
        return (statusString == null || statusString.isEmpty()) ? DATA : findAllByStatus(Status.valueOf(statusString.toUpperCase()));
    }

    public List<Todo> findAllByStatus(Status status) {
        return DATA.stream().filter(t -> t.getStatus().equals(status)).collect(Collectors.toList());
    }

    public void removeById(Long id) {
        DATA.remove(findById(id));
    }

    @Override
    public void setStatus(Long id, Status status) {
        this.findById(id).get().setStatus(status);
    }

    public void removeByStatus(Status status) {
        findAllByStatus(Status.COMPLETE).forEach(t -> {
            this.removeById(t.getId());
        });
    }

    public void toggleStatus(Long id) {
        Todo todo = findById(id).get();
        if (todo.isCompleted()) {
            todo.setStatus(Status.ACTIVE);
        } else {
            todo.setStatus(Status.COMPLETE);
        }
    }

    public void toggleAll(boolean complete) {
        this.findAll().forEach(t -> t.setStatus(complete ? Status.COMPLETE : Status.ACTIVE));
    }

    public List<Todo> findAll() {
        return DATA;
    }

}
