package com.giovana.farmacia_api.service;

import com.giovana.farmacia_api.dto.medicamentoDTO.MedicamentoRequestDTO;
import com.giovana.farmacia_api.dto.medicamentoDTO.MedicamentoResponseDTO;
import com.giovana.farmacia_api.exception.NotFoundException;
import com.giovana.farmacia_api.mapper.MedicamentoMapper;
import com.giovana.farmacia_api.model.Medicamento;
import com.giovana.farmacia_api.repository.MedicamentoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;
    private final MedicamentoMapper medicamentoMapper;

    public MedicamentoResponseDTO saveMedicamento(MedicamentoRequestDTO requestDTO) {
        Medicamento medicamento = medicamentoMapper.toEntity(requestDTO);

        Medicamento savedMedicamento = medicamentoRepository.save(medicamento);

        return medicamentoMapper.toResponse(savedMedicamento);
    }

    public List<MedicamentoResponseDTO> findAllMedicamentos() {
        List<Medicamento> medicamentoList = medicamentoRepository.findAll();

        return medicamentoMapper.toResponseList(medicamentoList);
    }

    @Transactional
    public MedicamentoResponseDTO updateMedicamento(Long id, MedicamentoRequestDTO requestDTO) {
        Medicamento existingMedicamento = medicamentoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Medicamento não encontrado."));

        existingMedicamento.setNome(requestDTO.getNome());
        existingMedicamento.setPreco(requestDTO.getPreco());

        Medicamento updatedMedicamento = medicamentoRepository.save(existingMedicamento);
        return medicamentoMapper.toResponse(updatedMedicamento);
    }

    public void deleteMedicamento(Long id) {
        Medicamento medicamento = medicamentoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Medicamento não encontrado."));

        medicamentoRepository.delete(medicamento);
    }
}
