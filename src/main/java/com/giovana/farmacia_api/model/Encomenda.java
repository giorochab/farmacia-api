package com.giovana.farmacia_api.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "encomenda")
public class Encomenda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Medicamento medicamento;

    private OffsetDateTime dataHora;

    @Builder
    public Encomenda( Medicamento medicamento, OffsetDateTime dataHora) {
        this.medicamento = medicamento;
        this.dataHora = dataHora;
    }
}
