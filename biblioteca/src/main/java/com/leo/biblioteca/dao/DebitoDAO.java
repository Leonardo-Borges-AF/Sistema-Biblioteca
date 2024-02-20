package com.leo.biblioteca.dao;

import java.util.List;

import com.leo.biblioteca.entity.DebitoEntity;

public interface DebitoDAO {
    List<DebitoEntity> listarDebito(String matricula);
    DebitoEntity adicionarDebito(DebitoEntity debito);
}
