package com.leo.biblioteca.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.leo.biblioteca.dao.DebitoDAO;
import com.leo.biblioteca.entity.DebitoEntity;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class DebitoRepository implements DebitoDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<DebitoEntity> listarDebito(String matricula) {
        return entityManager.createQuery("SELECT d FROM debitos d WHERE d.aluno.matricula = :matricula", DebitoEntity.class)
                .setParameter("matricula", matricula)
                .getResultList();
    }

    @Transactional
    @Override
    public DebitoEntity adicionarDebito(DebitoEntity debito) {
        entityManager.persist(debito);
        return debito;
    }
}
