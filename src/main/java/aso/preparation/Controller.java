package aso.preparation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class Controller {

    private static final String BASE_URL = "/api/";
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping(BASE_URL)
    public List<TodoList> getAll() {
        log.info("GET {}", BASE_URL);
        return service.findAll();
    }

    @GetMapping(BASE_URL + "{id}")
    public List<TodoEntry> getEntriesForTodoListId(@PathVariable Long id) {
        log.info("GET {}/{}", BASE_URL, id);
        return service.findEntriesForTodoListId(id);
    }

    @PostMapping(BASE_URL)
    public TodoList create(@RequestBody TodoList todoList) {
        log.info("POST {} using body {}", BASE_URL, todoList.toString());
        return service.save(todoList);
    }

    @PostMapping(BASE_URL + "solution1")
    public List<Point> generateSolution1(@RequestBody Assignment1 assignment1) {
        log.info("POST {} using body {}", BASE_URL + "solution1", assignment1.toString());
        return service.generateSolution1(assignment1);
    }

    @PostMapping(BASE_URL + "solution2")
    public List<Point> generateSolution2(@RequestBody Assignment2 assignment2) {
        log.info("POST {} using body {}", BASE_URL + "solution2", assignment2.toString());
        return service.generateSolution2(assignment2);
    }

    @PostMapping(BASE_URL + "solution3")
    public List<Point> generateSolution3(@RequestBody Assignment3 assignment3) {
        log.info("POST {} using body {}", BASE_URL + "solution3", assignment3.toString());
        return service.generateSolution3(assignment3);
    }

    @PostMapping(BASE_URL + "solution4")
    public List<Point> generateSolution4(@RequestBody Assignment4 assignment4) {
        log.info("POST {} using body {}", BASE_URL + "solution4", assignment4.toString());
        return service.generateSolution4(assignment4);
    }


}
