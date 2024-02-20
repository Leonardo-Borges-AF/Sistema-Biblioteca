package com.leo.biblioteca.dto.itememprestimo;

import java.util.Date;

import com.leo.biblioteca.entity.LivroEntity;

public record ItemEmprestimoResponse(
        int id,
        Date dataPrevista,
        LivroEntity livro
) {
}
