package io.lucasteles.taskmanager.task_manager_api.repository;

import io.lucasteles.taskmanager.task_manager_api.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    List<User> findByNameOrEmail(String name, String email);
    List<User> findByNameAndEmail(String name, String email);
}
