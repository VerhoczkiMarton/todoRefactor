package com.verho.todorefactor.service;

import com.verho.todorefactor.model.Todo;
import com.verho.todorefactor.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RemoveService {
    @Autowired
    @Qualifier("db")
    TodoRepository todoRepository;

    public void removeTodosCompleted() {
        List<Todo> todos = todoRepository.findAll();
        todos.stream()
                .filter(Todo::isCompleted)
                .forEach(todo -> todoRepository.removeById(todo.getId()));
    }

    public void removeByID(Long id) {
        todoRepository.removeById(id);
    }
}
