package io.lucasteles.taskmanager.task_manager_api.controller.dto;

import io.lucasteles.taskmanager.task_manager_api.model.entity.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record UserDTO(
        Long id,
        String name,
        String email,
        String createdAt,
        String dateUpdate) {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public static UserDTO fromUser(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt() != null ? user.getCreatedAt().format(formatter) : null,
                user.getDateUpdate() != null ? user.getDateUpdate().format(formatter) : null
        );
    }

    public User mappingToUser() {
        User user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        return user;
    }
}
