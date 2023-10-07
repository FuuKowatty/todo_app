package pl.bartoszmech.todo;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private final Scanner scanner = new Scanner(System.in);
    private final Repository repository;

    @Autowired
    public Application(Repository repository) {
        this.repository = repository;
    }


    public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) {

		int chose;
		do {

			printMenu();
			chose = scanner.nextInt();
			scanner.nextLine();

			switch (chose) {
				case 1:
					viewTodos();
					break;
				case 2:
					addTask();
					break;
				case 3:
					deleteTask();
					break;
				case 4:
					completeTask();
					break;
				case 5:
					quitApp();
					break;
				default:
					// Do something else here.
					break;
			}
		} while (chose != 5);
	}

	private void quitApp() {
	}

	private void completeTask() {
		Long id = askForId();
		Optional<Todo> todo = repository.findById(id);
		if(todo.isPresent()) {
			todo.get().setIsCompleted(true);
			repository.save(todo.get());
		} else {
			System.out.println("Provided id does not exist");
		}

	}

	private void deleteTask() {
		Long id = askForId();
		repository.deleteById(id);
	}

	private Long askForId() {
		viewTodos();
		System.out.println("Provide id of task you want delete");
		Long id = scanner.nextLong();
		scanner.nextLine();

		return id;
	}

	private void addTask() {
		Todo newTodo = new Todo();
		System.out.println("What is the title of task? ");
		String title = scanner.nextLine();

		System.out.println("What is the description of task? ");
		String description = scanner.nextLine();

		newTodo.setTitle(title);
		newTodo.setDescription(description);

		repository.save(newTodo);
		System.out.println("User added successfully");
	}

	private void printMenu() {
		System.out.println("TODO MENU");
		System.out.println("1. VIEW TODOS");
		System.out.println("2. ADD TASK");
		System.out.println("3. DELETE TASK");
		System.out.println("4. MARK TASK AS COMPLETED");
		System.out.println("5. QUIT");
	}

	private void viewTodos() {
		List<Todo> todos = repository.findAll();

		if (!todos.isEmpty()) {
			todos.forEach(t -> System.out.println(t.toString()));
			return;
		}

		System.out.println("Your list is empty");
	};

}
