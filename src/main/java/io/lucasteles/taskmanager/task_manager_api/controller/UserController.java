package io.lucasteles.taskmanager.task_manager_api.controller;

import io.lucasteles.taskmanager.task_manager_api.controller.dto.UserDTO;
import io.lucasteles.taskmanager.task_manager_api.model.entity.User;
import io.lucasteles.taskmanager.task_manager_api.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> createdUser(@RequestBody UserDTO user) {
        User userEntity = user.mappingToUser();
        service.saveUser(userEntity);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userEntity.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        Optional<User> userOptional = service.getUserById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            UserDTO dto = UserDTO.fromUser(user);
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>>
    findUser(@RequestParam(value = "name", required = false) String name,
             @RequestParam(value = "email", required = false) String email) {
        List<User> result = service.find(name, email);
        List<UserDTO> list = result.stream()
                .map(UserDTO::fromUser).collect(Collectors.toList());

        return ResponseEntity.ok(list);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updateUser = service.updateUser(id, user);
        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        Optional<User> userOptional = service.getUserById(id);
        if (userOptional.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        service.deleteUser(userOptional.get());
        return ResponseEntity.noContent().build();
    }

}
