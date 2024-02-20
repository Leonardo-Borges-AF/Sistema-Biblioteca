package com.leo.biblioteca.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.biblioteca.entity.LivroEntity;
import com.leo.biblioteca.service.LivroService;

@RestController
@RequestMapping("api/livro")
public class LivroControler {
    @Autowired
    private LivroService service;

    @GetMapping
    public ResponseEntity<List<LivroEntity>> listarLivros() {
        return ResponseEntity.ok(service.listarLivros());
    }

    @PostMapping("/cadastrarLivro")
    public ResponseEntity<LivroEntity> cadastrarLivro(@RequestBody LivroEntity livro) {
        return ResponseEntity.ok(service.cadastrarLivro(livro));
    }
}
