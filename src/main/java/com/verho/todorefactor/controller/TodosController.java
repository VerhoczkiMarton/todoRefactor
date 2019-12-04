package com.verho.todorefactor.controller;

import com.verho.todorefactor.service.FindService;
import com.verho.todorefactor.service.RemoveService;
import com.verho.todorefactor.service.ToggleService;
import com.verho.todorefactor.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/todos")
public class TodosController {

    @Autowired
    RemoveService removeService;

    @Autowired
    ToggleService toggleService;

    @Autowired
    UpdateService updateService;

    @Autowired
    FindService findService;

    @DeleteMapping("/completed")
    void removeCompleted() {
        removeService.removeTodosCompleted();
    }

    @PutMapping("/toggle_all")
    void toggleAll() {
        toggleService.toggleAll();
    }


    @DeleteMapping("/{id}")
    void removeById(@PathVariable Long id) {
        removeService.removeByID(id);
    }

    @PutMapping("/{id}")
    void updateTitleById(@RequestParam("todo-title") String title, @PathVariable Long id) {
        updateService.updateTitleById(id, title);
    }

    @GetMapping("/{id}")
    String findById(@PathVariable Long id) {
        return findService.getTodoById(id).getTitle();
    }

    @PutMapping("/{id}/toggle_status")
    void toggleById(@PathVariable Long id) {
        toggleService.toggleById(id);
    }

}
