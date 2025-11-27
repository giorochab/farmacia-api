package com.giovana.farmacia_api.dto.medicamentoDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentoResponseDTO {

    private Long id;

    private String nome;

    private Double preco;
}
