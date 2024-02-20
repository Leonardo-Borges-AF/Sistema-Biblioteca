package com.leo.biblioteca.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.biblioteca.entity.AlunoEntity;
import com.leo.biblioteca.service.AlunoService;
import java.util.List;

@RestController
@RequestMapping("api/aluno")
public class AlunoControler {

    @Autowired
    private AlunoService service;

    @GetMapping
    public ResponseEntity<List<AlunoEntity>> listarAlunos() {
        return ResponseEntity.ok(service.listarAlunos());
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<AlunoEntity> listarPorMatricula(@PathVariable(value = "matricula") String matricula) {
        return ResponseEntity.ok(service.listarPorId(matricula));
    }

    @PostMapping("/cadastrarAluno")
    public ResponseEntity<AlunoEntity> cadastrarAluno(@RequestBody AlunoEntity aluno) {
        return ResponseEntity.ok(service.cadastrarAluno(aluno));
    }

    
}