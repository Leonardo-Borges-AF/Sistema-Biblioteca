package com.leo.biblioteca.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "itens_emprestimo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ItemEmprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date dataPrevista;

    @ManyToOne
    @JoinColumn(name = "livro_id", referencedColumnName = "id")
    private LivroEntity livro;

    @ManyToOne
    @JoinColumn(name = "emprestimo_id", referencedColumnName = "id")
    private EmprestimoEntity emprestimo;
}
