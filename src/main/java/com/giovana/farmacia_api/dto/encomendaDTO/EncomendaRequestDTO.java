package com.giovana.farmacia_api.dto.encomendaDTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EncomendaRequestDTO {

    @NotEmpty(message = "Informe o nome do medicamento desejado.")
    private String nomeMedicamento;

    @NotNull(message = "Informe a quantidade desejada.")
    @Min(value = 1, message = "Quantidade mínima: 1")
    @Max(value = 10, message = "Quantidade máxima: 10")
    private Integer quantidade;

}
