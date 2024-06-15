package br.edu.unicesumar.perguntou.domain.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public User findByUsername(String username) {
       return entityManager.createQuery("select u from User u where u.username = :username", User.class)
                .setParameter("username", username)
                .getSingleResult();
    }
}
