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

@Entity(name = "item_devolucao")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ItemDevolucao {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private Date dataDevolucao;
    private int diasAtraso;
    private float valor_devolucao;
    private float multa_devolucao;
    @ManyToOne
    @JoinColumn(name = "livro_id", referencedColumnName = "id")
    private LivroEntity livro;
    @ManyToOne
    @JoinColumn(name = "devolucao_id", referencedColumnName = "id")
    private DevolucaoEntity devolucao;
}
