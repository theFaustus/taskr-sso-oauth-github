package com.evil.inc.taskrssokeycloak;

import com.evil.inc.taskrssokeycloak.domain.Task;
import com.evil.inc.taskrssokeycloak.domain.Priority;
import com.evil.inc.taskrssokeycloak.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskrSsoOAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskrSsoOAuthApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(TaskRepository taskRepository){
		return args -> {
			taskRepository.save(new Task("Read!", "Start reading, at least 30 minutes per day", Priority.HIGH, "theFaustus"));
			taskRepository.save(new Task("Workout", "Need to workout", Priority.HIGH, "theFaustus"));
			taskRepository.save(new Task("Meditate", "Get some mindfulness", Priority.MEDIUM, "theFaustus"));
			taskRepository.save(new Task("Be nice", "Give smiles", Priority.LOW, "theFaustus"));
			taskRepository.save(new Task("Eat bananas", "One banana a day, keeps the doctor away", Priority.LOW, "theFaustus"));
		};
	}
}
