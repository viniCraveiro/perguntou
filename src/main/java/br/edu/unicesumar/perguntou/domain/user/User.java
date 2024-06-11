package br.edu.unicesumar.perguntou.domain.user;

import br.edu.unicesumar.perguntou.domain.Entidade;
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
    @Column(length = 100, nullable = false)
    @Email
    private String email;
    @Column(nullable = false)
    private String password;

    public User() {
    }

    public User(Long id, String name, String email, String password) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
