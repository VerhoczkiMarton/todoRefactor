package com.verho.todorefactor.controller;

import com.verho.todorefactor.model.Status;
import com.verho.todorefactor.model.Todo;
import com.verho.todorefactor.service.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddController {
    @Autowired
    AddService addService;

    @PostMapping(value = "/addTodo", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    void addTodo(@RequestParam("todo-title") String title) {
        addService.addTodo(Todo.builder().title(title).status(Status.ACTIVE).build());
    }
}
