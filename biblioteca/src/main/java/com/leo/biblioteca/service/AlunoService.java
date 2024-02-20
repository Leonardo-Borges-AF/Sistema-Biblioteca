package com.leo.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leo.biblioteca.entity.AlunoEntity;
import com.leo.biblioteca.repository.AlunoRepository;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoDAO;

    public List<AlunoEntity> listarAlunos() {
        return alunoDAO.findAll();
    }

    public AlunoEntity listarPorId(String matricula) {
        return alunoDAO.findById(matricula);
    }

    public AlunoEntity cadastrarAluno(AlunoEntity aluno) {
        return alunoDAO.save(aluno);
    }
}