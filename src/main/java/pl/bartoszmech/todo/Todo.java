package pl.bartoszmech.todo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.Text;

import java.time.LocalDateTime;

@Entity
@Table(name = "todos")
@Getter
@Setter
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(
            name = "title",
            nullable = false,
            length = 50
    )
    private String title;
    @Column(
            name = "description",
            columnDefinition="TEXT"
    )
    private String description;

    @Column(
            name="is_completed"
    )
    private Boolean isCompleted = false;

    @Column(
            name="created_at",
            columnDefinition = "TIMESTAMP DEFAULT NOW()"
    )
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(
            name="updated_at"
    )
    private LocalDateTime updatedAt;

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", isCompleted=" + isCompleted +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
