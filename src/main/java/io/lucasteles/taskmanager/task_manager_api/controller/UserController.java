package io.lucasteles.taskmanager.task_manager_api.controller;

import io.lucasteles.taskmanager.task_manager_api.model.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @PostMapping
    public ResponseEntity<Object> registerUser(@RequestBody User user){

    }

}
