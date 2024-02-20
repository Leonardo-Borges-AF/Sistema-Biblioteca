package com.leo.biblioteca.dao;

import java.util.List;
import java.util.Optional;

import com.leo.biblioteca.entity.AlunoEntity;

public interface AlunoDAO {
    AlunoEntity findById(String matricula);
    List<AlunoEntity> findAll();
    AlunoEntity save(AlunoEntity aluno);
}

