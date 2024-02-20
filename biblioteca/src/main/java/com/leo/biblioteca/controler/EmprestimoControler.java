package com.leo.biblioteca.controler;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.biblioteca.entity.EmprestimoEntity;
import com.leo.biblioteca.service.EmprestimoService;
import com.leo.biblioteca.dto.emprestimo.EmprestimoResponse;
import com.leo.biblioteca.dto.emprestimo.EmprestimoRequestDTO;

@RestController
@RequestMapping("api/emprestimo")
public class EmprestimoControler {
    @Autowired
    private EmprestimoService service;

    @GetMapping
    public ResponseEntity<List<EmprestimoEntity>> listarEmprestimos() {
        return ResponseEntity.ok(service.listarEmprestimos());
    }

    @PostMapping("/cadastrarEmprestimo")
    public ResponseEntity<EmprestimoResponse> cadastrarEmprestimo(@RequestBody EmprestimoRequestDTO emprestimoRequest) {
        return ResponseEntity.ok(service.cadastrarEmprestimo(emprestimoRequest));
    }
}