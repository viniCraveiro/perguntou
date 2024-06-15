package br.edu.unicesumar.perguntou.domain.user;

public interface UserRepositoryCustom {
    User findByUsername(String username);
}
