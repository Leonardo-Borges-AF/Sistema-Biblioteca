package com.leo.biblioteca.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.leo.biblioteca.dao.LivroDAO;
import com.leo.biblioteca.entity.LivroEntity;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class LivroRepository implements LivroDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public LivroEntity findById(String id) {
        return null;
    }

    @Override
    public List<LivroEntity> findAll() {
        return entityManager.createQuery("SELECT a FROM livros a", LivroEntity.class).getResultList();
    }

    @Transactional
    @Override
    public LivroEntity save(LivroEntity livro) {
        entityManager.persist(livro);
        return livro;
    }
}
