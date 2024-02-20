package com.leo.biblioteca.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leo.biblioteca.entity.TituloEntity;
import com.leo.biblioteca.repository.TituloRepository;

import java.util.List;

@Service
public class TituloService {
    @Autowired
    private TituloRepository tituloDAO;

    public List<TituloEntity> listarTitulos() {
        return tituloDAO.findAll();
    }

    public TituloEntity cadastrarTitulo(TituloEntity titulo) {
        return tituloDAO.save(titulo);
    }
}