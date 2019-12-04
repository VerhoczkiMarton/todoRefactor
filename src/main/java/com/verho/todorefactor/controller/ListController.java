package com.verho.todorefactor.controller;

import com.verho.todorefactor.model.Todo;
import com.verho.todorefactor.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListController {

    @Autowired
    ListService listService;

    @PostMapping(value = "/list", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    List<Todo> list(@RequestParam("status") String statusString) {
        return listService.getTodosByStatusString(statusString);
    }
}
