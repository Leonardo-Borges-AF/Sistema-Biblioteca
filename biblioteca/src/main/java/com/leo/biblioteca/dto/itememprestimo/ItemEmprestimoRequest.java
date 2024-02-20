package com.leo.biblioteca.dto.itememprestimo;

import com.leo.biblioteca.entity.LivroEntity;

public record ItemEmprestimoRequest(
        LivroEntity livro
) {
}