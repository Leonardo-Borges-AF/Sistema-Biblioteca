package com.leo.biblioteca.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.leo.biblioteca.dao.TituloDAO;
import com.leo.biblioteca.entity.TituloEntity;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class TituloRepository implements TituloDAO {
    @Autowired
    private EntityManager entityManager;
    @Override
    public TituloEntity findById(Long id) {
        return null;
    }

    @Override
    public TituloEntity findByIsbn(String isbn) {
        return null;
    }

    @Override
    public List<TituloEntity> findAll() {
        return entityManager.createQuery("SELECT a FROM titulos a", TituloEntity.class).getResultList();
    }

    @Transactional
    @Override
    public TituloEntity save(TituloEntity titulo) {
        entityManager.persist(titulo);
        return titulo;
    }
}
