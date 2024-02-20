package com.leo.biblioteca.dao;

import com.leo.biblioteca.entity.EmprestimoEntity;
import java.util.List;

public interface EmprestimoDAO {
    EmprestimoEntity procurarEmprestimo(int id);
    EmprestimoEntity procurarAlunoEmprestimo(String matricula);
    List<EmprestimoEntity> mostrarTodos();
    EmprestimoEntity salvarEmprestimo(EmprestimoEntity emprestimo);

}
