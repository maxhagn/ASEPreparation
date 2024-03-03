package aso.preparation;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TodoEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer color;

    @ManyToOne
    @JoinColumn(name = "todo_list_id")
    @JsonBackReference
    private TodoList todoList;
}