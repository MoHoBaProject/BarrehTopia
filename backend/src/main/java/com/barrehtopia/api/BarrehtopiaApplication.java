package com.barrehtopia.api;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class BarrehtopiaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BarrehtopiaApplication.class, args);
    }

    // Seed one row into the database at startup
    @Bean
    CommandLineRunner seedData(MessageRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                Message message = new Message();
                message.setText("Hello from the Barrehtopia database!");
                repository.save(message);
            }
        };
    }
}

// --- Entity ---
@Entity
class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

// --- Repository ---
interface MessageRepository extends JpaRepository<Message, Long> {
}

// --- Controller ---
@RestController
@CrossOrigin(origins = "http://localhost:4200")
class MessageController {

    private final MessageRepository repository;

    MessageController(MessageRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/message")
    public String getMessage() {
        return repository.findAll()
                .stream()
                .findFirst()
                .map(Message::getText)
                .orElse("No message found");
    }
}
