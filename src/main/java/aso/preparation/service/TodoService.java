package aso.preparation.service;

import aso.preparation.entity.TodoEntry;
import aso.preparation.entity.TodoList;
import aso.preparation.repository.TodoEntryRepository;
import aso.preparation.repository.TodoListRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TodoService {

    private final TodoListRepository todoListRepository;
    private final TodoEntryRepository todoEntryRepository;

    public TodoService(TodoListRepository todoListRepository, TodoEntryRepository todoEntryRepository) {
        this.todoListRepository = todoListRepository;
        this.todoEntryRepository = todoEntryRepository;
    }

    public List<TodoList> findAll() {
        return todoListRepository.findAll();
    }

    public List<TodoEntry> findEntriesForTodoListId(Long id) {
        return todoEntryRepository.findByTodoListId(id);
    }

    public TodoList save(TodoList beispiel) {
        return todoListRepository.save(beispiel);
    }

}
