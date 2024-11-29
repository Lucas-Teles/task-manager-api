package io.lucasteles.taskmanager.task_manager_api.service;

import io.lucasteles.taskmanager.task_manager_api.model.entity.User;
import io.lucasteles.taskmanager.task_manager_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User saveUser(User user) {
        return repository.save(user);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUserById(Long id){
        Optional<User> userFound = repository.findById(id);
        return userFound;
    }

    public User updateUser(Long id, User user) {
        Optional<User> existingUserOptional = repository.findById(id);
        User existingUser = existingUserOptional.get();

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());

        return repository.save(existingUser);
    }

    public void deleteUser(Long id) {
        User user = repository.findById(id).get();
        repository.delete(user);
    }
}
