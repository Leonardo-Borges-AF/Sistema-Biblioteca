package com.leo.biblioteca.dto.emprestimo;

import com.leo.biblioteca.dto.itememprestimo.ItemEmprestimoRequest;

import java.util.Date;

import java.util.List;

public record EmprestimoRequestDTO(
        Date dataEmprestimo,
        List<ItemEmprestimoRequest> itensEmprestimo,
        String alunoMatricula
) {
}