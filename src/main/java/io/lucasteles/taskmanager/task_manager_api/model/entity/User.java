package io.lucasteles.taskmanager.task_manager_api.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    @NotBlank(message = "Este campo não pode ser vazio")
    private String name;
    @Column(name = "email", unique = true, nullable = false)
    @Email(message = "Email digitado inválido")
    @NotBlank(message = "Este campo não pode ser vazio")
    private String email;

    @CreationTimestamp
    @Column(name = "created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createdAt;

    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public Long getId(){return id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
