package com.task.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.task.entity")
@SpringBootApplication
@ComponentScan(basePackages = "com.task")  // Ensure it scans your package
@EnableJpaRepositories(basePackages = "com.task.dao") // Ensure it finds your repository
public class TaskManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaskManagerApplication.class, args);
    }
}
