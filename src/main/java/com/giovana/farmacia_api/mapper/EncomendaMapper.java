package com.giovana.farmacia_api.mapper;

import org.mapstruct.Mapper;
import com.giovana.farmacia_api.dto.encomendaDTO.EncomendaRequestDTO;
import com.giovana.farmacia_api.dto.encomendaDTO.EncomendaResponseDTO;
import com.giovana.farmacia_api.model.Encomenda;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EncomendaMapper {

    Encomenda toEntity(EncomendaRequestDTO encomendaRequestDTO);

    EncomendaResponseDTO toResponse(Encomenda encomenda);

    List<EncomendaResponseDTO> toResponseList(List<Encomenda> encomendaList);
}
