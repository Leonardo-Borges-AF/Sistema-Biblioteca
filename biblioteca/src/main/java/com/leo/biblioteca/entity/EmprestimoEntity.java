package com.leo.biblioteca.entity;

import java.util.Date;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Emprestimo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class EmprestimoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private float valor_multa_devolucao;
    @OneToOne
    @Nullable
    private DevolucaoEntity devolucao;
    @ManyToOne
    private AlunoEntity aluno;
}
