package com.leo.biblioteca.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity(name = "debitos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class DebitoEntity {
    @Id
    private Long id;
    private float valor;
    private Date data;
    @ManyToOne
    @JoinColumn(name = "alunomatricula", referencedColumnName = "matricula")
    private AlunoEntity aluno;
}


