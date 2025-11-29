package com.giovana.farmacia_api.controller;

import com.giovana.farmacia_api.dto.medicamentoDTO.MedicamentoRequestDTO;
import com.giovana.farmacia_api.dto.medicamentoDTO.MedicamentoResponseDTO;
import com.giovana.farmacia_api.service.MedicamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicamentos")
@RequiredArgsConstructor
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    @PostMapping
    public ResponseEntity<MedicamentoResponseDTO> createMedicamento(@Valid @RequestBody MedicamentoRequestDTO requestDTO) {
        MedicamentoResponseDTO savedMedicamento = medicamentoService.saveMedicamento(requestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedMedicamento);
    }

    @GetMapping
    public ResponseEntity<List<MedicamentoResponseDTO>> getAllMedicamentos() {
        return ResponseEntity.ok(medicamentoService.findAllMedicamentos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicamentoResponseDTO> updateMedicamento(@PathVariable Long id, @Valid @RequestBody MedicamentoRequestDTO requestDTO) {
        MedicamentoResponseDTO updatedMedicamento = medicamentoService.updateMedicamento(id, requestDTO);

        return ResponseEntity.ok(updatedMedicamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicamento(@PathVariable Long id) {
        medicamentoService.deleteMedicamento(id);

        return ResponseEntity.noContent().build();
    }

}
