package aso.preparation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoEntryRepository extends JpaRepository<TodoEntry, Long> {

    @Query(value = "SELECT * FROM todo_entry WHERE todo_list_id = ?1", nativeQuery = true)
    List<TodoEntry> findByTodoListId(Long todoListId);

}