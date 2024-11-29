package io.lucasteles.taskmanager.task_manager_api.config;

import io.lucasteles.taskmanager.task_manager_api.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseInitializer implements CommandLineRunner {

    public static final Logger log = LoggerFactory.getLogger(DatabaseInitializer.class);
    private final UserRepository userRepository;

    public DatabaseInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Bora lucão !");
        log.info("O banco conectou");
    }
}
