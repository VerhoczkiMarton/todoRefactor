package com.verho.todorefactor.service;

import com.verho.todorefactor.model.Status;
import com.verho.todorefactor.model.Todo;
import com.verho.todorefactor.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListService {

    @Autowired
    @Qualifier(value = "db")
    TodoRepository todoRepository;

    public List<Todo> getTodosByStatus(Status status) {
        if (status == null) {
            return todoRepository.findAll();
        } else {
            return todoRepository.findAllByStatus(status);
        }
    }

    public List<Todo> getTodosByStatusString(String statusString) {
        if (statusString.equals("")) {
            return todoRepository.findAll();
        } else {
            return todoRepository.findAllByStatusString(statusString);
        }
    }
}
