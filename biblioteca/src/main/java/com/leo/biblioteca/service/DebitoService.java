package com.leo.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leo.biblioteca.repository.DebitoRepository;
import com.leo.biblioteca.entity.DebitoEntity;

@Service
public class DebitoService {
    @Autowired
    private DebitoRepository debitoRepository;

    public List<DebitoEntity> listarDebito(String matricula) {
        return debitoRepository.listarDebito(matricula);
    }

    public DebitoEntity adicionarDebito(DebitoEntity debito) {
        return debitoRepository.adicionarDebito(debito);
    }
}
