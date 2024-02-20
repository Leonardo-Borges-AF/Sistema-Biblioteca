package com.leo.biblioteca.dao;

import java.util.List;

import com.leo.biblioteca.entity.ItemEmprestimo;

public interface ItemEmprestimoDao {
    ItemEmprestimo findById(int id);
    ItemEmprestimo findByEmprestimo(int emprestimoId);
    boolean findByLivro(Long livroId);
    List<ItemEmprestimo> findAll();
    ItemEmprestimo save(ItemEmprestimo itemEmprestimo);
}
