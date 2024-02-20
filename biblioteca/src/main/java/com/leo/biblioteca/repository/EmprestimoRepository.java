package com.leo.biblioteca.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.leo.biblioteca.dao.EmprestimoDAO;
import com.leo.biblioteca.entity.EmprestimoEntity;

import jakarta.persistence.EntityManager;


@Repository
public class EmprestimoRepository implements EmprestimoDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public EmprestimoEntity procurarEmprestimo(int id) {
        return null;
    }

    @Override
    public EmprestimoEntity procurarAlunoEmprestimo(String matricula) {
        return null;
    }

    @Override
    public List<EmprestimoEntity> mostrarTodos() {
        return entityManager.createQuery("SELECT a FROM emprestimos a", EmprestimoEntity.class).getResultList();
    }

    @Override
    public EmprestimoEntity salvarEmprestimo(EmprestimoEntity emprestimo) {
        entityManager.persist(emprestimo);
        return emprestimo;
    }
    
}
