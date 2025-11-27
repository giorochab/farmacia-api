package com.giovana.farmacia_api.mapper;

import com.giovana.farmacia_api.dto.medicamentoDTO.MedicamentoRequestDTO;
import com.giovana.farmacia_api.dto.medicamentoDTO.MedicamentoResponseDTO;
import com.giovana.farmacia_api.model.Medicamento;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicamentoMapper {

    Medicamento toEntity(MedicamentoRequestDTO dto);

    MedicamentoResponseDTO toResponse(Medicamento medicamento);

    List<MedicamentoResponseDTO> toResponseList(List<Medicamento> listMedicamentos);
}
