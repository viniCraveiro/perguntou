package br.edu.unicesumar.perguntou.domain;

import jakarta.persistence.*;

import java.util.Objects;

@MappedSuperclass
public abstract class Entidade implements IEntidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    protected Entidade() {
    }

    protected Entidade(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entidade entidade = (Entidade) o;
        return Objects.equals(id, entidade.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
