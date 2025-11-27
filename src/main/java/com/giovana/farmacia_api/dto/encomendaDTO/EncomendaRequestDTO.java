package com.giovana.farmacia_api.dto.encomendaDTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EncomendaRequestDTO {

    @NotNull(message = "Informe o ID do medicamento.")
    private Long medicamentoId;

}
