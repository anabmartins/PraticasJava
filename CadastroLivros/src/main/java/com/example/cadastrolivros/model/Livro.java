package com.example.cadastrolivros.model;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
@Entity
@Getter
@Setter
public class Livro {
    @Id
    private Long isbn;
    private String nome;
    private int ano;

    @ManyToOne
    private Autor autor;

    @ManyToOne
    private Genero genero;
}
