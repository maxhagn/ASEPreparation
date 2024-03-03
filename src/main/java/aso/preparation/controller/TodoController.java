package aso.preparation.controller;

import aso.preparation.entity.TodoEntry;
import aso.preparation.entity.TodoList;
import aso.preparation.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class TodoController {

    private static final String BASE_URL = "/api/todo/";
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping(BASE_URL)
    public List<TodoList> getAll() {
        log.info("GET {}", BASE_URL);
        return todoService.findAll();
    }

    @GetMapping(BASE_URL + "{id}")
    public List<TodoEntry> getEntriesForTodoListId(@PathVariable Long id) {
        log.info("GET {}/{}", BASE_URL, id);
        return todoService.findEntriesForTodoListId(id);
    }

    @PostMapping(BASE_URL)
    public TodoList create(@RequestBody TodoList todoList) {
        log.info("POST {} using body {}", BASE_URL, todoList.toString());
        return todoService.save(todoList);
    }

}
