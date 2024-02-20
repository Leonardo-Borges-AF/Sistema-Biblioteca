package com.leo.biblioteca.dao;

import java.util.List;

import com.leo.biblioteca.entity.LivroEntity;

public interface LivroDAO {
    LivroEntity findById(String id);
    List<LivroEntity> findAll();
    LivroEntity save(LivroEntity livro);
}
