package com.giovana.farmacia_api.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "medicamento")
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private Double preco;

    @Builder
    public Medicamento( String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }
}
