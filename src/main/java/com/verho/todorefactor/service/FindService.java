package com.verho.todorefactor.service;

import com.verho.todorefactor.model.Todo;
import com.verho.todorefactor.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FindService {

    @Autowired
    @Qualifier(value = "db")
    TodoRepository todoRepository;

    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).get();
    }
}
