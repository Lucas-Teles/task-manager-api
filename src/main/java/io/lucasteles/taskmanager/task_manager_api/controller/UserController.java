package io.lucasteles.taskmanager.task_manager_api.controller;

import io.lucasteles.taskmanager.task_manager_api.model.entity.User;
import io.lucasteles.taskmanager.task_manager_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<User> createdUser(@RequestBody User user){
        User createdUser = service.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = service.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long id){
        Optional<User> user = service.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        User updateUser = service.updateUser(id, user);
        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
