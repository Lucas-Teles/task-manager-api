package io.lucasteles.taskmanager.task_manager_api.controller.dto;

import io.lucasteles.taskmanager.task_manager_api.model.entity.User;

public record UserDTO(
        String name,
        String email) {

    public User mappingToUser(){
        User user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        return user;
    }
}
