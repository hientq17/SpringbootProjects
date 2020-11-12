package edu.fpt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class QuizletCloneApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuizletCloneApplication.class, args);
    }

}
