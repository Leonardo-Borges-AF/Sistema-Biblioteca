package com.leo.biblioteca.entity;


import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "livros")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class LivroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean exemplar;
    private boolean disponivel;
    private Date prazo;
    
    @ManyToOne
    @JoinColumn(name = "titulo_id", referencedColumnName = "id")
    private TituloEntity titulo;
}
