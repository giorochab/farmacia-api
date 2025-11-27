package com.giovana.farmacia_api.dto.medicamentoDTO;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentoRequestDTO {

    @NotEmpty(message = "O nome é obrigatório.")
    private String nome;

    @NotNull(message = "O preço é obrigatório.")
    @DecimalMin(value = "0.0", inclusive = true, message = "O preço não deve ser negativo.")
    private Double preco;

}
