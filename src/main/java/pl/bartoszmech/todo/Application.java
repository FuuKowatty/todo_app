package pl.bartoszmech.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private Repository repository;

    @Autowired
    public Application(Repository repository) {
        this.repository = repository;
    }


    public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) {
		Scanner scanner = new Scanner(System.in);
		int chose;
		do {

			printMenu();
			chose = scanner.nextInt();

			switch (chose) {
				case 1:
					//view todos
					viewTodos();
					break;
				case 2:
					// add task
					addTask();
					break;
				case 3:
					//delete todos
					break;
				case 4:
					//edit todos
					break;
				case 5:
					//quit todos
					break;
				default:
					// Do something else here.
					break;
			}
		} while (chose != 5);
	}

	private void addTask() {
	}

	private void printMenu() {
		System.out.println("TODO MENU");
		System.out.println("1. VIEW TODOS");
		System.out.println("2. ADD TASK");
		System.out.println("3. DELETE TASK");
		System.out.println("4. EDIT TASK");
		System.out.println("5. QUIT");
	}

	private void viewTodos() {
		List<Todo> todos = repository.findAll();
		System.out.println(todos.isEmpty() ? "Your list is empty" : todos);
	};

}
