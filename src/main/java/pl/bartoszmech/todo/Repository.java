package pl.bartoszmech.todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Repository extends JpaRepository<Todo, Long> {
}
