package com.giovana.farmacia_api.dto.encomendaDTO;

import com.giovana.farmacia_api.dto.medicamentoDTO.MedicamentoResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EncomendaResponseDTO {

    private Long id;

    private MedicamentoResponseDTO medicamento;

    private Integer quantidade;

    private OffsetDateTime dataHora;
}
