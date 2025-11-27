package com.giovana.farmacia_api.service;

import com.giovana.farmacia_api.dto.encomendaDTO.EncomendaRequestDTO;
import com.giovana.farmacia_api.dto.encomendaDTO.EncomendaResponseDTO;
import com.giovana.farmacia_api.exception.NotFoundException;
import com.giovana.farmacia_api.mapper.EncomendaMapper;
import com.giovana.farmacia_api.model.Encomenda;
import com.giovana.farmacia_api.model.Medicamento;
import com.giovana.farmacia_api.repository.EncomendaRepository;
import com.giovana.farmacia_api.repository.MedicamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EncomendaService {

    private final EncomendaRepository encomendaRepository;
    private final MedicamentoRepository medicamentoRepository;
    private final EncomendaMapper encomendaMapper;

    public EncomendaResponseDTO saveEncomenda(EncomendaRequestDTO requestDTO) {
        Medicamento medicamento = medicamentoRepository.findById(requestDTO.getMedicamentoId())
                .orElseThrow(() -> new NotFoundException("O ID não corresponde a nenhum medicamento."));

        Encomenda encomenda = encomendaMapper.toEntity(requestDTO);

        encomenda.setMedicamento(medicamento);
        encomenda.setDataHora(OffsetDateTime.now());

        Encomenda savedEncomenda = encomendaRepository.save(encomenda);

        return encomendaMapper.toResponse(savedEncomenda);
    }

    public List<EncomendaResponseDTO> findAllEncomendas() {
       List<Encomenda> encomendaList = encomendaRepository.findAll();

       return encomendaMapper.toResponseList(encomendaList);
    }

    public void deleteEncomenda(Long id) {
        Encomenda encomenda = encomendaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Encomenda não encontrada."));

        encomendaRepository.delete(encomenda);
    }

}
