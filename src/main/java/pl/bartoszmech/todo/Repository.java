package pl.bartoszmech.todo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Todo, Long> {
}
