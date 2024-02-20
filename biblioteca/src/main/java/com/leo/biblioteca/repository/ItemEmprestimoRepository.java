package com.leo.biblioteca.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.leo.biblioteca.dao.ItemEmprestimoDao;
import com.leo.biblioteca.entity.ItemEmprestimo;

import jakarta.persistence.EntityManager;


@Repository
public class ItemEmprestimoRepository implements ItemEmprestimoDao{

    @Autowired
    private EntityManager entityManager;

    @Override
    public ItemEmprestimo findById(int id) {
        return null;
    }

    @Override
    public ItemEmprestimo findByEmprestimo(int emprestimoId) {
       return null;
    }

    @Override
    public List<ItemEmprestimo> findAll() {
        return entityManager.createQuery("SELECT a FROM itens_emprestimo a", ItemEmprestimo.class).getResultList();
    }

    @Override
    public ItemEmprestimo save(ItemEmprestimo itemEmprestimo) {

        entityManager.persist(itemEmprestimo);

        return itemEmprestimo;

    }

    @Override
    public boolean findByLivro(Long livroId) {
        return entityManager.createQuery("SELECT EXISTS (SELECT a FROM itens_emprestimo a WHERE a.livro.id = :livro_id)", Boolean.class).setParameter("livro_id", livroId).getSingleResult();

    }
    
}
