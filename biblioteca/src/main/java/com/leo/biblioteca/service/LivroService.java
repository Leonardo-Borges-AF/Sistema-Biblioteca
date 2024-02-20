package com.leo.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leo.biblioteca.entity.LivroEntity;
import com.leo.biblioteca.repository.LivroRepository;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroDAO;

    public List<LivroEntity> listarLivros() {
        return livroDAO.findAll();
    }

    public LivroEntity cadastrarLivro(LivroEntity livro) {
        return livroDAO.save(livro);
    }
}
