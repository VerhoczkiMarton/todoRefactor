package com.verho.todorefactor.service;

import com.verho.todorefactor.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UpdateService {

    @Autowired
    @Qualifier("db")
    TodoRepository todoRepository;

    public void updateTitleById(Long id, String title) {
        todoRepository.update(id, title);
    }
}
