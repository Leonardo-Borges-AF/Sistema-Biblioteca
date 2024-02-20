package com.leo.biblioteca.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.leo.biblioteca.dao.AlunoDAO;
import com.leo.biblioteca.entity.AlunoEntity;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;



@Repository
public class AlunoRepository implements AlunoDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public AlunoEntity findById(String matricula) {
            return entityManager.createQuery("SELECT a FROM alunos a WHERE a.matricula = :matricula", AlunoEntity.class)
                    .setParameter("matricula", matricula)
                    .getSingleResult();
    }

    @Override
    public List<AlunoEntity> findAll() {
        return entityManager.createQuery("SELECT a FROM alunos a", AlunoEntity.class).getResultList();
    }

    @Transactional
    @Override
    public AlunoEntity save(AlunoEntity aluno) {
        entityManager.persist(aluno);
        return aluno;
    }


}

    