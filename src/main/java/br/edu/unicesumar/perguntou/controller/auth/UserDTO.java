package br.edu.unicesumar.perguntou.controller.auth;

import br.edu.unicesumar.perguntou.domain.user.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Username is required")
    private String username;

    @Email
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    public UserDTO() {
    }

    public UserDTO(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserDTO(User user) {
        this.name = user.getName();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

}
