package com.leo.biblioteca.dao;

import java.util.List;

import com.leo.biblioteca.entity.TituloEntity;

public interface TituloDAO {
    
    TituloEntity findById(Long id);
    TituloEntity findByIsbn(String isbn);
    List<TituloEntity> findAll();
    TituloEntity save(TituloEntity titulo);

}
