package br.edu.unicesumar.perguntou.domain;

import jakarta.persistence.*;

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

    public boolean isNovo() {
        return id == null;
    }
}
