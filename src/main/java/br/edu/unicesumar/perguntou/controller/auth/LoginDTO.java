package br.edu.unicesumar.perguntou.controller.auth;

import lombok.Getter;

@Getter
public class LoginDTO {

    public String username;
    public String password;

    public LoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
