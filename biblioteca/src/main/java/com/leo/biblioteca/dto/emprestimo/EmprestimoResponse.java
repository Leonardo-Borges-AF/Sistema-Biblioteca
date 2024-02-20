package com.leo.biblioteca.dto.emprestimo;

import java.util.Date;
import java.util.List;

import com.leo.biblioteca.dto.itememprestimo.ItemEmprestimoResponse;
import com.leo.biblioteca.entity.AlunoEntity;
import com.leo.biblioteca.entity.DevolucaoEntity;

public class EmprestimoResponse {
    private Long id;
    private Date dataEmprestimo;
    private AlunoEntity aluno;
    private DevolucaoEntity devolucao;
    private List<ItemEmprestimoResponse> itensEmprestimo;

    public EmprestimoResponse(Long id, Date dataEmprestimo, AlunoEntity aluno, DevolucaoEntity devolucao, List<ItemEmprestimoResponse> itensEmprestimo) {
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.aluno = aluno;
        this.devolucao = devolucao;
        this.itensEmprestimo = itensEmprestimo;
    }

    // Outros métodos e getters/setters...
}