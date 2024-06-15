package br.edu.unicesumar.perguntou.domain.user;

import br.edu.unicesumar.perguntou.domain.Entidade;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@DynamicUpdate
@Entity
@Table(name = "USERS")
public class User extends Entidade {

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false, unique = true)
    private String username;

    @Column(length = 100, nullable = false)
    @Email
    private String email;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    protected User() {
    }

    public User(Long id, String name, String username, String email, String password) {
        super(id);
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
