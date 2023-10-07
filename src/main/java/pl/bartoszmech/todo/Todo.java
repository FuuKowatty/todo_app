package pl.bartoszmech.todo;

import jakarta.persistence.*;
import org.w3c.dom.Text;

import java.time.LocalDateTime;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @Column(columnDefinition="TEXT")
    private String description;

    @Column(name="is_completed")
    private Boolean isCompleted;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

}
