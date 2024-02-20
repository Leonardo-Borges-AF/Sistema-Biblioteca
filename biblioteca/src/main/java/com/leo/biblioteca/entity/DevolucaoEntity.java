package com.leo.biblioteca.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "devolucao")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class DevolucaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dataDevoculao;
    private boolean atraso;
    private float valorTotal;
    private float multa;
    @OneToMany
    private List<ItemDevolucao> itensDevolucao;
}
