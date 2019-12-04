package com.verho.todorefactor.service;

import com.verho.todorefactor.model.Status;
import com.verho.todorefactor.model.Todo;
import com.verho.todorefactor.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ToggleService {

    @Autowired
    @Qualifier("db")
    TodoRepository todoRepository;

    public void toggleAll() {
        List<Todo> todos = todoRepository.findAll();
        todos.stream().forEach((todo) -> {
            if (todo.isCompleted()) todoRepository.setStatus(todo.getId(), Status.ACTIVE);
            else todoRepository.setStatus(todo.getId(), Status.COMPLETE);
        });
    }

    public void toggleById(Long id) {
        Todo todo = todoRepository.findById(id).get();
        if (todo.isCompleted()) todoRepository.setStatus(todo.getId(), Status.ACTIVE);
        else todoRepository.setStatus(todo.getId(), Status.COMPLETE);

    }
}
